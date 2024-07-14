package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidCredentials")
    //   data { email, password, errorMsg, emailValidationMsg, passwordValidationMsg }
    public static Object invalidCredentials(){
        Object[][] data = {
                {"shobuj@yopmail.com", "shobuj", "Your email or password is incorrect!", "", ""},
                {"shbu@yopmail.com", "shobuj123", "Your email or password is incorrect!", "", ""},
                {"shbou@gmail.cm", "asdfa", "Your email or password is incorrect!", "", ""},
                {"shobuj@yopmail.com", "", "", "", "Please fill out this field."},
                {"", "shobuj123", "", "Please fill out this field.", ""},
                {"", "", "", "Please fill out this field.", ""},
                {"shobuj.com", "adsfa", "", "Please include an '@' in the email address. 'shobuj.com' is missing an '@'.", ""},
                {"shobuj@", "adsfa", "", "Please enter a part following '@'. 'shobuj@' is incomplete.", ""},
                {"@gmail", "adsfa", "", "Please enter a part followed by '@'. '@gmail' is incomplete.", ""},
                        };
        return data;
    }
}
