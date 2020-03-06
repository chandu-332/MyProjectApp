package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.util.UomUtil;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("uom",new Uom());
	 		return "UomRegister";
	}
	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom Uom, Model model){
		Integer id=service.saveUom(Uom);
		String message="Uom '"+ id +"' saved";
		model.addAttribute("Uom",new Uom());
		model.addAttribute("message", message);
		return "UomRegister";
	}
	@RequestMapping("/all") //GET
	public String getAllUoms(Model model) {
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	@RequestMapping("/delete") //GET
	public String deleteUoms(@RequestParam("uid") Integer id , Model model)
	{
		service.deleteUom(id);
		String message="Uom '"+id+"' Deleted";
		model.addAttribute("message", message);

		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list); 
		return "UomData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam( "uid") Integer id,Model model) {

		Uom st=service.getOneUom(id);
		model.addAttribute("Uom",st);
		return "UomEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom Uom,Model model) {
		service.updateUom(Uom);
		String message="Uom '"+Uom.getuId()+"' Updated";
		model.addAttribute("message",message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list); 
		return "UomData";
	}
	@RequestMapping("/view")
	public String showOneUom(@RequestParam( "uid") Integer id,Model model) {
		Uom st=service.getOneUom(id);
		model.addAttribute("ob",st);
		return "UomView";
	}
	/*@RequestMapping("/excel")
	public ModelAndView showExcel(){
		ModelAndView  m=new ModelAndView();
		m.setView(new UomExcelView());
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf() {
		ModelAndView  m=new ModelAndView();
		m.setView(new UomPdfView());
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		return m;	
	}*/
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id",required=false)Integer id){
		ModelAndView  m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==null) {
			List<Uom> list=service.getAllUoms();
			m.addObject("list",list);	
		}
		else {
			Uom st=service.getOneUom(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView  m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
			List<Uom> list=service.getAllUoms();
			m.addObject("list",list);	
		}else 
		{
		Uom st=service.getOneUom(id);
		m.addObject("list",Arrays.asList(st));
		}
		return m;	
	}
	@RequestMapping("/charts")
	public String showCharts() {
	List<Object[]> list=service.getUomModeCount();
	String path=context.getRealPath("/");
	util.generatePie(path, list);
	util.generateBar(path, list);
	return "UomCharts";
	}

}