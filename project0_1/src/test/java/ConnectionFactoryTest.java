import com.revanture.chaslsBank.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionFactoryTest {

    @Test
    public void whenGetConnectionIsCalledDoesNotThrowException(){
        Assertions.assertDoesNotThrow(ConnectionFactory::getConnection);
    }
}
