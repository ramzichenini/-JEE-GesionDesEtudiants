package com.example.demo.web;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Value("${dir.images}")
	private String imageDir ;
	
	@RequestMapping(value="/Index")
	public String Index(Model model, 
			@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		Page<Etudiant> pageEtudiants=etudiantRepository.chercherEtudiants("%"+mc+"%",
				new PageRequest(p, 5));
		int pageCount=pageEtudiants.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0; i<pageCount; i++)
			pages[i]=i;
		 
		model.addAttribute("pages",pages );
		model.addAttribute("pageEtudiants", pageEtudiants);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "etudiants";
	}
	
	@RequestMapping(value="/form" , method=RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("etudiant",new Etudiant());
		return "formEtudiant";
	}
	
	@RequestMapping(value="/SaveEtudiant" , method=RequestMethod.POST)
	public String save( Etudiant et,@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException {
		
		
		
		if(!(file.isEmpty() )) {et.setPhoto(file.getOriginalFilename());	
		}
		
		etudiantRepository.save(et);
		
		if(!(file.isEmpty() )) {
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(imageDir+ et.getId()));
		}
		
		
		return "redirect:Index";
	}
	
	// comment afficher une photo 
	
	@RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long id) throws Exception {
		File f=new File(imageDir+id);
		return IOUtils.toByteArray(new FileInputStream(f));
	
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id) {
		etudiantRepository.delete(id);
		return "redirect:Index";
	}
	
	@RequestMapping(value="/edit")
	public String edit(Long id,  Model model) {
		Etudiant et=etudiantRepository.getOne(id);
		model.addAttribute("etudiant", et);
		return "EditEtudiant";
	}
	
	
	@RequestMapping(value="/UpdateEtudiant" , method=RequestMethod.POST)
	public String update( Etudiant et,@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException {
		
		
		
		if(!(file.isEmpty() )) {et.setPhoto(file.getOriginalFilename());	
		}
		
		etudiantRepository.save(et);
		
		if(!(file.isEmpty() )) {
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(imageDir+ et.getId()));
		}
		
		
		return "redirect:Index";
	}
	

}
