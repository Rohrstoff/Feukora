package test.project.feukora.server.persister;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Customerheater;
import projekt.feukora.server.model.Facilitymanager;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.persister.BlowerPersister;
import projekt.feukora.server.persister.BlowerPersisterImpl;
import projekt.feukora.server.persister.CustomerPersister;
import projekt.feukora.server.persister.CustomerPersisterImpl;
import projekt.feukora.server.persister.CustomerheaterPersisterImpl;
import projekt.feukora.server.persister.FacilitymanagerPersister;
import projekt.feukora.server.persister.FacilitymanagerPersisterImpl;
import projekt.feukora.server.persister.HeaterPersister;
import projekt.feukora.server.persister.HeaterPersisterImpl;

public class CustomerheaterPersisterTest {

	private static CustomerheaterPersisterImpl customerheaterTest = new CustomerheaterPersisterImpl();

	@Before
	public void setUp() throws Exception {
		CustomerheaterPersisterTest.init();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSave() throws Exception {
		
		List<Customerheater> customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 2);
		
		CustomerPersister cp = new CustomerPersisterImpl();
		Customer c = cp.findCustomerByCustomerid(0);
		
		HeaterPersister hp = new HeaterPersisterImpl();
		Heater h = hp.findHeaterByHeaterid(0);
		
		BlowerPersister bp = new BlowerPersisterImpl();
		Blower b = bp.findByBlowerid(1);
		
		FacilitymanagerPersister fmp = new FacilitymanagerPersisterImpl();
		Facilitymanager fm = fmp.findFacilitymanagerByFacilitymanagerid(1);

		Customerheater ch = new Customerheater (c, h, b, fm, 2006, 2010, 280);

		customerheaterTest.saveCustomerheater(ch);

		customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 3);

	}
	
	@Ignore
	@Test
	public void testUpdate() throws Exception {

		List<Customerheater> customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 2);
		
		CustomerPersister cp = new CustomerPersisterImpl();
		Customer c = cp.findCustomerByCustomerid(0);
		
		HeaterPersister hp = new HeaterPersisterImpl();
		Heater h = hp.findHeaterByHeaterid(0);
		
		BlowerPersister bp = new BlowerPersisterImpl();
		Blower b = bp.findByBlowerid(1);
		
		FacilitymanagerPersister fmp = new FacilitymanagerPersisterImpl();
		Facilitymanager fm = fmp.findFacilitymanagerByFacilitymanagerid(1);

		Customerheater ch = new Customerheater (c, h, b, fm, 2006, 2010, 280);

		customerheaterTest.saveCustomerheater(ch);

		customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 3);

		ch.setHeateryear(2007);

		customerheaterTest.updateCustomerheater(ch);

	}

	@Ignore
	@Test
	public void testDelete() throws Exception {

		List<Customerheater> customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 2);

		customerheaterTest.deleteCustomerheater(customerheaterlist.get(0));

		customerheaterlist = customerheaterTest.findAllCustomerheaters();
		assertTrue(customerheaterlist.size() == 1);

	}

	public static List<Customerheater> init() throws Exception {

		CustomerheaterPersisterTest.deleteAll();
		
		CustomerPersister cp = new CustomerPersisterImpl();
		Customer c1 = cp.findCustomerByCustomerid(0);
		Customer c2 = cp.findCustomerByCustomerid(1);
		
		HeaterPersister hp = new HeaterPersisterImpl();
		Heater h1 = hp.findHeaterByHeaterid(0);
		Heater h2 = hp.findHeaterByHeaterid(1);
		
		BlowerPersister bp = new BlowerPersisterImpl();
		Blower b1 = bp.findByBlowerid(1);
		Blower b2 = bp.findByBlowerid(0);
		
		FacilitymanagerPersister fmp = new FacilitymanagerPersisterImpl();
		Facilitymanager fm1 = fmp.findFacilitymanagerByFacilitymanagerid(1);
		Facilitymanager fm2 = fmp.findFacilitymanagerByFacilitymanagerid(0);

		Customerheater ch1 = new Customerheater (c1, h1, b1, fm1, 1000, 1000, 5);
		Customerheater ch2 = new Customerheater (c2, h2, b2, fm2, 2000, 2000, 200);

		customerheaterTest.saveCustomerheater(ch1);
		customerheaterTest.saveCustomerheater(ch2);

		List<Customerheater> customerheaterlist = new ArrayList<>();
		customerheaterlist.add(ch1);
		customerheaterlist.add(ch2);

		return customerheaterlist;
	}

	private static void deleteAll() throws Exception {

		for (Customerheater ch : customerheaterTest.findAllCustomerheaters()) {
			customerheaterTest.deleteCustomerheater(ch);
		}
	}
}