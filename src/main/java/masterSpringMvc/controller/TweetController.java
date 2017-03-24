package masterSpringMvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TweetController {
	
	@Autowired
	private Twitter twitter;
	
	@RequestMapping("/")
	public String hello(@RequestParam(defaultValue = "TajnikiSpringMVC4") String search, Model model){
		SearchResults searchResults = twitter.searchOperations().search(search);
		List<String> tweets = searchResults.getTweets().stream().map(Tweet::getText).collect(Collectors.toList());
		model.addAttribute("tweets",tweets);
		return "resultPage";
	}
	
}
