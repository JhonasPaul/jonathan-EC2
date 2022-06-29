package EC2.jonathan.ortiz.bodega.bodega.dto;

public class ProductoDTOResponse {
    private Long idProducto;
    private String productoProducto;
    private String descripcionProducto;
    private Double precioProducto;
    private int stockProducto;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getProductoProducto() {
        return productoProducto;
    }

    public void setProductoProducto(String productoProducto) {
        this.productoProducto = productoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }


}
