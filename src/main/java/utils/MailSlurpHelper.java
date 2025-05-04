package utils;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSlurpHelper {
    private final InboxControllerApi inboxControllerApi;
    private final WaitForControllerApi waitForControllerApi;

    public MailSlurpHelper(String apiKey) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setApiKey(apiKey);
        this.inboxControllerApi = new InboxControllerApi(apiClient);
        this.waitForControllerApi = new WaitForControllerApi(apiClient);
    }

    public InboxDto generateInbox() throws ApiException {
        return inboxControllerApi.createInboxWithDefaults();
    }

    public String waitForOtpFromEmail(String inboxId, long timeoutMs) throws ApiException {
        Email email = waitForControllerApi.waitForLatestEmail(
                UUID.fromString(inboxId),
                timeoutMs,             // ⏱ total wait time (e.g., 60000L for 60s)
                true,                  // wait only for unread emails
                null,                  // before date
                null,                  // since date
                null,                  // sort by
                null                   // delay in ms between retries
        );

//        Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(email.getBody());
//        if (matcher.find()) return matcher.group();
//        throw new RuntimeException("OTP not found in email body");
        String body = email.getBody();
        if (body == null) throw new ApiException("Email body is null");

        Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(body);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new ApiException("❌ OTP not found in email body:\n" + body);
        }
    }
}
