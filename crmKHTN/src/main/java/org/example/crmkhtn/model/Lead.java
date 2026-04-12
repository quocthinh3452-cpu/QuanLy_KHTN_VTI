package org.example.crmkhtn.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lead_id")
    private Integer leadId;

    // Database: varchar(50)
    @NotBlank(message = "Tên liên hệ không được để trống!")
    @Size(max = 50, message = "Tên liên hệ không vượt quá 50 ký tự")
    @Column(name = "contact_name", nullable = false, length = 50)
    private String contactName;

    // Database: varchar(50)
    @Size(max = 50, message = "Tên công ty không vượt quá 50 ký tự")
    @Column(name = "company_name", length = 50)
    private String companyName;

    // Database: varchar(10)
    @Pattern(regexp = "^[0-9]{10}$|^$", message = "Số điện thoại phải bao gồm đúng 10 chữ số")
    @Column(name = "phone", length = 10)
    private String phone;

    // Database: varchar(255)
    @Email(message = "Email không đúng định dạng (VD: abc@gmail.com)")
    @Size(max = 255, message = "Email không vượt quá 255 ký tự")
    @Column(name = "email")
    private String email;

    // Database: varchar(150)
    @Size(max = 150, message = "Địa chỉ không vượt quá 150 ký tự")
    @Column(name = "address", length = 150)
    private String address;

    // Database: int
    @Column(name = "province_id")
    private Integer provinceId;

    // Database: decimal(15,2)
    @Min(value = 0, message = "Doanh thu dự kiến không được là số âm")
    @Column(name = "expected_revenue")
    private BigDecimal expectedRevenue;

    // Database: varchar(15)
    @Pattern(regexp = "^[0-9A-Za-z-]{10,15}$|^$", message = "Mã số thuế không hợp lệ")
    @Size(max = 15, message = "Mã số thuế không vượt quá 15 ký tự")
    @Column(name = "tax_code", length = 15)
    private String taxCode;

    // Database: varchar(12)
    @Pattern(regexp = "^[0-9]{12}$|^$", message = "Căn cước công dân phải bao gồm đúng 12 chữ số")
    @Column(name = "citizen_id", length = 12)
    private String citizenId;

    // Database: int
    @Column(name = "status_id")
    private Integer statusId;

    // Database: int
    @Column(name = "source_id")
    private Integer sourceId;

    // Database: int
    @Column(name = "sales_group_id")
    private Integer salesGroupId;
}