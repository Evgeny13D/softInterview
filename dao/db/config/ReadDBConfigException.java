package A402.dao.db.config;

/**
 * Created by Evgeny on 5/9/18.
 */
public class ReadDBConfigException extends RuntimeException {
    private static final long serialVersionUID = -8249206598946789173L;

    public ReadDBConfigException() {
    }

    public ReadDBConfigException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ReadDBConfigException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ReadDBConfigException(String arg0) {
        super(arg0);
    }

    public ReadDBConfigException(Throwable arg0) {
        super(arg0);
    }
}
