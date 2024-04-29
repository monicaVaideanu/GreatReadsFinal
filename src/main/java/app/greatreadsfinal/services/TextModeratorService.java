package app.greatreadsfinal.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TextModeratorService {
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://api.sightengine.com/1.0/text/check.json";

    @Value("${sightengine.user}")
    private String apiUser;

    @Value("${sightengine.secret}")
    private String apiSecret;

    public TextModeratorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isTextAppropriate(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);
        params.put("lang", "en");
        params.put("mode", "standard");
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(
                apiUrl + "?api_user={apiUser}&api_secret={apiSecret}&text={text}&lang={lang}&mode={mode}",
                Map.class, apiUser, apiSecret, text, "en", "standard"
        );

        Map<String, Object> response = responseEntity.getBody();
        if (response != null && response.containsKey("profanity")) {
            Map profanity = (Map) response.get("profanity");
            List matches = (List) profanity.get("matches");
            return matches == null || matches.isEmpty();
        }
        return true;
    }
}
