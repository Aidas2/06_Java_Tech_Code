package it.akademija.springapp.dto.inventory;

public class SectorDTO {

    private Integer sector;
    private Integer count;

    public SectorDTO() {
    }

    public SectorDTO(Integer sector, Integer count) {
        this.sector = sector;
        this.count = count;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
