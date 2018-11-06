package nhutt.harjoitustyo.wowtasklist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nhutt.harjoitustyo.wowtasklist.domain.CharacterRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Character;


@Controller
public class CharacterController {
	
	@Autowired
	private CharacterRepository characterRepository;
	
    // REST-palvelu, joka palauttaa kaikki hahmot
    @RequestMapping(value="/characters", method = RequestMethod.GET)
    public @ResponseBody List<Character> characterListRest() {	
        return (List<Character>) characterRepository.findAll();
    }   
    
	/** palauttaa listauksen kaikista tietokannassa olevista hahmoista **/
	@RequestMapping(value="/characterlist", method=RequestMethod.GET)
	public String getCharacterlist(Model model) {
		model.addAttribute("characters", characterRepository.findAll());
		
		return "characterlist";
	}
	
	/** palauttaa tyhjän lomakkeen uuden hahmon lisäämiseen **/
	@RequestMapping(value = "/addcharacter")
    public String addCharacter(Model model){
    	model.addAttribute("character", new Character());
        return "addcharacter";
        
	}
	
	/** tallentaa hahmon tiedot ja palaa listaukseen **/
    @RequestMapping(value = "/savecharacter", method = RequestMethod.POST)
    public String saveCharacter(Character character){
        characterRepository.save(character);
        return "redirect:characterlist";
    }  
    
    /** palauttaa tietyn hahmon editointisivun **/
	@RequestMapping(value = "/editcharacter/{id}")
    public String editCharacter(@PathVariable("id") Long characterId, Model model) {
    	model.addAttribute("character", characterRepository.findById(characterId));
        return "editcharacter";
    }  
	
	/** poistaa tietyn hahmon id:n perusteella **/
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/deletecharacter/{id}")
	public String deleteCharacter(@PathVariable("id") Long characterId) {
		characterRepository.deleteById(characterId);
		
		return "redirect:../characterlist";
		
	}
	
}
