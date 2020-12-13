package lk.ijse.pos.view.tm;

import com.jfoenix.controls.JFXButton;

public class OrderTM {
    private String id;
    private String date;
    private String customerId;
    private JFXButton btn;

    public OrderTM() {
    }

    public OrderTM(String id, String date, String customerId, JFXButton btn) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", btn=" + btn +
                '}';
    }
}

