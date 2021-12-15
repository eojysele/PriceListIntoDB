package Mail;

import Сonfiguration.Config;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Mail {
    public String MailList() throws MessagingException {
        String fileName = null;
        Properties properties = new Properties();
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties);
        Store store = null;
        Config configFile = new Config();
        //Получаем значения из config.properties в соответствии с указанным ключем
        String protocol = configFile.getValue("mail.protocol");
        String host = configFile.getValue("mail.server");
        int port = Integer.parseInt(configFile.getValue("mail.port"));
        String user = configFile.getValue("mail.user");
        String password = configFile.getValue("mail.password");
        String sender = configFile.getValue("mail.sender");
        String folder = configFile.getValue("mail.folder");

        try {
        store = session.getStore(protocol);
        store.connect(host, port, user, password);
        Folder inbox = null;

            try {
                inbox = store.getFolder(folder);
                inbox.open(Folder.READ_ONLY);
                int count = inbox.getMessageCount();
                Message[] messages = inbox.getMessages(1, count);
                String l = messages[1].getSubject();
                System.out.println(messages.length);
                for (int i = messages.length-1; i>0; i--) {
                    String from = ((InternetAddress) messages[i].getFrom()[0]).getAddress();
                    if (from.equals(sender)) {
                        System.out.println("FROM: " + from);
                        System.out.println("SUBJECT: " + messages[i].getSubject());
                        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy'-'hh:mm:ss");
                        String date = formatDate.format(messages[i].getReceivedDate()).toString();
                        System.out.println("FROM: " + date);
                        Object content = messages[i].getContent();
                        if (content instanceof Multipart) {
                            Multipart multipart = (Multipart) messages[i].getContent();
                            for (int j = 0; j < multipart.getCount(); j++) {
                                BodyPart bodyPart = multipart.getBodyPart(j);
                                if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                                    continue;
                                }
                                InputStream is = bodyPart.getInputStream();
                                File f = new File("/home/eojysele/Downloads/" + date + "-" + bodyPart.getFileName());
                                saveFile(f, bodyPart);
                                fileName = f.getAbsolutePath();
                            }
                            break;
                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inbox != null) {
                    inbox.close(false);
                }
            }

        } finally {
            if (store != null) {
                store.close();
            }
        }

        return fileName;
    }
    private static int saveFile(File saveFile, Part part) throws Exception {

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(saveFile));
        byte[] buffer = new byte[204800];
        InputStream is = part.getInputStream();
        int ret = 0, count = 0;
        while ((ret = is.read(buffer)) > 0) {
            bos.write(buffer, 0, ret);
            count += ret;
        }
        bos.close();
        is.close();
        return count;
    }
}
