package nhutt.harjoitustyo.wowtasklist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nhutt.harjoitustyo.wowtasklist.domain.CharacterRepository;
import nhutt.harjoitustyo.wowtasklist.domain.Character;


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

}
