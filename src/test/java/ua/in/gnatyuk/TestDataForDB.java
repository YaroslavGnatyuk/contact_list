package ua.in.gnatyuk;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import ua.in.gnatyuk.configuration.PersistentTestContext;

@ContextConfiguration(classes = {PersistentTestContext.class})
@ComponentScan("ua.in.gnatyuk")
public class TestDataForDB {
}
