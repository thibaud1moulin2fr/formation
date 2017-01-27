package fr.thibaud.testgestionparking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPersonneDAO.class, TestVoitureDAO.class })
public class AllTests {

}
