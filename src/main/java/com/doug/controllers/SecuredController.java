package  com.doug.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Doug on 10/13/16.
 */
@Controller
public class SecuredController {

	@RequestMapping("/secured")
	public String getSecured() {
		return "secured";
	}
}