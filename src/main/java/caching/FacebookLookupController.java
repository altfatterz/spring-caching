package caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@Controller
@RequestMapping("/lookup")
public class FacebookLookupController {

    private FacebookLookupService facebook;

    @Autowired
    public FacebookLookupController(FacebookLookupService facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page lookup(@RequestParam String name) {
        long start = System.currentTimeMillis();
        Page page = facebook.findPage(name);
        long elapsed = System.currentTimeMillis() - start;
        page.setLookupTime(elapsed);
        return page;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public @ResponseBody Error createError(HttpClientErrorException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setCode(e.getStatusCode().value());
        return error;
    }

}
