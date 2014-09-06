/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package homework.partialmocking.service.impl;

import homework.partialmocking.dao.ProviderDao;
import homework.partialmocking.domain.ServiceProducer;
import homework.staticmocking.osgi.ServiceRegistration;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * The purpose of this test is to get 100% coverage of the
 * {@link ProviderServiceImpl} class without any code changes to that class. To
 * achieve this you need learn how to create partial mocks, modify internal
 * state, invoke and expect private methods.
 * <p>
 * While doing this tutorial please refer to the documentation on how to expect
 * private methods and bypass encapsulation at the PowerMock web site.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ProviderServiceImpl.class)
public class ProviderServiceImplTest {
	
	private ProviderServiceImpl tested;
	private ProviderDao providerDaoMock;


	@Before
	public void setUp() {
		providerDaoMock = mock(ProviderDao.class);
		tested = spy(new ProviderServiceImpl());
        Whitebox.setInternalState(tested, "providerDao", providerDaoMock);
	}

	@After
	public void tearDown() {
		providerDaoMock = null;
        tested = null;
	}

	@Test
	public void testGetAllServiceProviders() throws Exception {
        HashSet<ServiceProducer> allServiceProduces = new HashSet<>();
        ServiceProducer serviceProducer = mock(ServiceProducer.class);
        allServiceProduces.add(serviceProducer);
        when(tested,"getAllServiceProducers").thenReturn(allServiceProduces);

        assertThat(tested.getAllServiceProviders(), Is.<Set<ServiceProducer>>is(allServiceProduces));

        verifyPrivate(tested).invoke("getAllServiceProducers");
	}

	@Test
	public void testGetAllServiceProviders_noServiceProvidersFound() throws Exception {
        Set<ServiceProducer> allServiceProduces = Collections.emptySet();
        when(tested,"getAllServiceProducers").thenReturn(null);

        assertThat(tested.getAllServiceProviders(), is( allServiceProduces) );

        verifyPrivate(tested).invoke("getAllServiceProducers");
	}

	@Test
	public void testServiceProvider_found() throws Exception {
		// TODO Create a partial mock of the ProviderServiceImpl mocking only the getAllServiceProducers method
		// TODO Create a new HashSet of ServiceProducer's and add a ServiceProducer to the set
		// TODO Expect the private method call to getAllServiceProducers and return the created HashSet
		// TODO Replay all mock objects used
		// TODO Perform the actual test and assert that the result matches the expectations  
		// TODO Verify all mock objects used
	}

	@Test
	public void testServiceProvider_notFound() throws Exception {
		// TODO Create a partial mock of the ProviderServiceImpl mocking only the getAllServiceProducers method
		// TODO Expect the private method call to getAllServiceProducers and return null
		// TODO Replay all mock objects used
		// TODO Perform the actual test and assert that the result matches the expectations 
		// TODO Verify all mock objects used 
	}

	@Test
	public void getAllServiceProducers() throws Exception {
		// TODO Create a new ServiceArtifact and a new HashSet place the created ServiceArtifact in this set
		// TODO Expect the call to the providerDao.getAllServiceProducers(..) and return the HashSet
		// TODO Replay all mock objects used
		// TODO Perform the actual test by invoking the private "getAllServiceProducers" method. Assert that the result matches the expectations.
		// TODO Verify all mock objects used
	}

	@Test
	public void getAllServiceProducers_empty() throws Exception {
		// TODO Create a new HashSet of ServiceArtifacts
		// TODO Replay all mock objects used
		// TODO Perform the actual test by invoking the private "getAllServiceProducers" method. Assert that the result matches the expectations.
		// TODO Verify all mock objects used
	}
}
