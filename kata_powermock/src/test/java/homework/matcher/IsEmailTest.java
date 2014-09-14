package homework.matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class IsEmailTest {
    @Test
    public void test_valid_email_should_be_accepted_by_email_matcher() {
        assertThat("hy@zy.com", is(IsEmail.isEmail()));
    }

    @Test
    public void test_multi_mailflag_email_should_not_be_accepted_by_email_matcher() throws Exception {
        assertThat("hy@zy@com", is(IsEmail.notEmail()));
    }

    @Test
    public void test_no_mailflag_email_should_not_be_accepted_by_email_matcher() {
        assertThat("a_zy.com", is(IsEmail.notEmail()));
    }

    @Test
    public void test_no_userid_email_should_not_be_accepted_by_email_matcher() {
        assertThat("@zy.com", is(IsEmail.notEmail()));
    }

    @Test
    public void test_no_host_email_should_not_be_accepted_by_email_matcher() {
        assertThat("hy@", is(IsEmail.notEmail()));
    }

    @Test
    public void test_null_should_not_be_accepted_by_email_matcher() {

        assertThat(null, is(IsEmail.notEmail()));
    }
}
