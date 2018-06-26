package th.co.maximus.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import th.co.maximus.bean.Employee;
import th.co.maximus.service.FirstPdf;
import th.co.maximus.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	HelloService service;

	@GetMapping("/")
	public String savePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", new ArrayList<Employee>());
		// (ArrayList<Employee>)employeeServiceInterface.getAllEmployees()
		return "index";
	}

	@PostMapping("/insert/save")
	public String save(@ModelAttribute("student") Employee employee, final RedirectAttributes redirectAttributes) {
		if (service.insert(employee)) {
			redirectAttributes.addFlashAttribute("saveStudent", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveStudent", "unsuccess");
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/download.pdf", method = RequestMethod.GET)
	public void print(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Document document = new Document();
		FirstPdf f = new FirstPdf();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			PdfWriter.getInstance(document, baos);
			document.open();
			f.addTitlePage(document);
			document.close();
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			// setting the content type
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
