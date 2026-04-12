package org.example.crmkhtn.controller;

import jakarta.validation.Valid; // Import mới
import org.example.crmkhtn.model.Lead;
import org.example.crmkhtn.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Import mới
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // Import mới

import java.util.List;

@Controller
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private LeadRepository leadRepository;

    @GetMapping
    public String listLeads(Model model) {
        List<Lead> leads = leadRepository.findAll();
        model.addAttribute("listLeads", leads);
        return "lead-list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("lead", new Lead());
        return "lead-form";
    }

    // THÊM/SỬA: Đã bổ sung Validation và Thông báo
    @PostMapping("/save")
    public String saveLead(@Valid @ModelAttribute("lead") Lead lead,
                           BindingResult result,
                           Model model, // Thêm model để đẩy lỗi
                           RedirectAttributes redirectAttributes) {

        // 1. Kiểm tra lỗi định dạng (Validation)
        if (result.hasErrors()) {
            return "lead-form";
        }

        // 2. Kiểm tra lỗi TRÙNG SỐ ĐIỆN THOẠI
        boolean isNew = (lead.getLeadId() == null);

        // Nếu là thêm mới, hoặc đang sửa nhưng đổi sang số SĐT của người khác
        if (lead.getPhone() != null && !lead.getPhone().isEmpty()) {
            // Kiểm tra xem SĐT này đã có ai dùng chưa
            Lead existingLead = leadRepository.findByPhone(lead.getPhone());

            if (existingLead != null && !existingLead.getLeadId().equals(lead.getLeadId())) {
                // Nếu tìm thấy người dùng SĐT này, mà ID lại khác với người đang sửa (hoặc đang thêm mới)
                result.rejectValue("phone", "error.lead", "Số điện thoại này đã tồn tại trong hệ thống!");
                return "lead-form"; // Trả về form và hiện chữ đỏ ở ô SĐT
            }
        }

        // 3. Nếu mọi thứ ok thì mới lưu xuống Database
        leadRepository.save(lead);

        redirectAttributes.addFlashAttribute("successMessage",
                isNew ? "Đã thêm Khách hàng tiềm năng thành công!" : "Đã cập nhật thông tin thành công!");
        return "redirect:/leads";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID: " + id));
        model.addAttribute("lead", lead);
        return "lead-form";
    }

    // XÓA: Đã bổ sung Try-Catch để chặn lỗi và hiện thông báo
    @GetMapping("/delete/{id}")
    public String deleteLead(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            leadRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Đã xóa khách hàng thành công!");
        } catch (Exception e) {
            // Xảy ra khi Khách hàng này đã ký Hợp đồng (có dữ liệu ở bảng khác nối vào)
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi: Không thể xóa khách hàng này vì đang có hợp đồng/báo giá liên quan!");
        }
        return "redirect:/leads";
    }
    // XEM CHI TIẾT
    @GetMapping("/view/{id}")
    public String viewLead(@PathVariable("id") Integer id, Model model) {
        // Tìm khách hàng theo ID, nếu không thấy thì báo lỗi
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Khách hàng ID: " + id));
        // Đẩy dữ liệu sang giao diện
        model.addAttribute("lead", lead);
        return "lead-view";
    }
}
