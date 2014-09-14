package homework.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.not;

/**
 * Created by zeya on 14-9-6.
 */
public class IsEmail<T> extends BaseMatcher<T> {

    private final String MAIL_FLAG = "@";

    @Override
    public boolean matches(Object item) {
        if (item == null || ! (item instanceof String)) return false;

        String emailString = (String) item;

        if ( ! isMailFlagExist(emailString) ) return false;
        if ( isMailFlagInLastPosition(emailString) ) return false;
        if (isExistMultiMailFlag(emailString)) return false;

        return true;
    }

    private boolean isExistMultiMailFlag(String emailString) {
        return emailString.indexOf(MAIL_FLAG) != emailString.lastIndexOf(MAIL_FLAG);
    }

    private boolean isMailFlagInLastPosition(String emailString) {
        return (emailString.indexOf(MAIL_FLAG) == emailString.length() - 1);
    }

    private boolean isMailFlagExist(String emailString) {
        return (emailString.indexOf(MAIL_FLAG) > 0);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("email address");
    }

    public static Matcher<Object> isEmail() {
        return new IsEmail();
    }

    public static Matcher<Object> notEmail() {
        return not(isEmail());
    }
}
