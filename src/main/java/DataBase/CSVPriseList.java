package DataBase;

import com.opencsv.bean.CsvBindByName;

public class CSVPriseList {
    @CsvBindByName(column = "Номенклатура")
    private String nomenclature;

    @CsvBindByName(column = "Бренд")
    private String brand;

    @CsvBindByName(column = "Артикул")
    private String partNumber;

    @CsvBindByName(column = "Описание")
    private String description;

    @CsvBindByName(column = "Вес/Объем")
    private String weight;

    @CsvBindByName(column = "Кратность отгрузки")
    private String shipment;

    @CsvBindByName(column = "Цена, руб.")
    private String price;

    @CsvBindByName(column = "Базовая цена, руб")
    private String basePrice;

    @CsvBindByName(column = "Наличие")
    private String availability;

    @CsvBindByName(column = "Срок поставки, дн.")
    private String deliveryTime;

    @CsvBindByName(column = "Каталожный номер")
    private String catalogNumber;

    @CsvBindByName(column = "OEМ Номер")
    private String OEMNumber;

    @CsvBindByName(column = "Применимость")
    private String applicability;

    @CsvBindByName(column = "Вендор-код")
    private String vendorID;

    public String getApplicability() {
        return applicability;
    }

    public String getBrand() {
        return brand;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public String getAvailability() {
        return availability;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getOEMNumber() {
        return OEMNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getShipment() {
        return shipment;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getWeight() {
        return weight;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setApplicability(String applicability) {
        this.applicability = applicability;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setOEMNumber(String OEMNumber) {
        this.OEMNumber = OEMNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    @Override
    public String toString() {
        return "CSVPriseList{" +
                "nomenclature='" + nomenclature + '\'' +
                ", brand='" + brand + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", description='" + description + '\'' +
                ", weight='" + weight + '\'' +
                ", shipment='" + shipment + '\'' +
                ", price='" + price + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", availability='" + availability + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", OEMNumber='" + OEMNumber + '\'' +
                ", applicability='" + applicability + '\'' +
                ", vendorID='" + vendorID + '\'' +
                '}';
    }
}
