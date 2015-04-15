package demo.test.config.version;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Application;
import demo.core.services.api.VersionService;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class, loader = SpringApplicationContextLoader.class)
public class TestVersion {

	
@Inject
VersionService versionService;


@Test
public void testVersion() throws Exception{
	assertTrue(versionService.getVersionNumber().equalsIgnoreCase("0.1-test"));
}


}
