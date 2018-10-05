package A402.dao;

/**
 * Created by Evgeny on 5/9/18.
 */
public class DaoException extends RuntimeException {
    private static final long serialVersionUID = 5367541674844392669L;

    public DaoException() {
    }

    public DaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DaoException(String arg0) {
        super(arg0);
    }

    public DaoException(Throwable arg0) {
        super(arg0);
    }
}
