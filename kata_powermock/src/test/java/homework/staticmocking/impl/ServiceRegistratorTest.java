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
package homework.staticmocking.impl;

import homework.staticmocking.osgi.BundleContext;
import homework.staticmocking.osgi.ServiceRegistration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * The purpose of this test is to get 100% coverage of the
 * {@link ServiceRegistrator} class without any code changes to that class. To
 * achieve this you need learn how to mock static methods as well as how to set
 * and get internal state of an object.
 * <p>
 * While doing this tutorial please refer to the documentation on how to mock
 * static methods and bypass encapsulation at the PowerMock web site.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({IdGenerator.class})
public class ServiceRegistratorTest {

	private BundleContext bundleContextMock;
	private ServiceRegistration serviceRegistrationMock;
	private ServiceRegistrator tested;

	@Before
	public void setUp() {
        bundleContextMock = mock(BundleContext.class);
		serviceRegistrationMock = mock(ServiceRegistration.class);
		tested = new ServiceRegistrator();
        Whitebox.setInternalState(tested, "bundleContext", bundleContextMock);
	}

	@After
	public void tearDown() {		
		bundleContextMock = null;
        serviceRegistrationMock = null;
	}

	/**
	 * Test for the {@link ServiceRegistrator#registerService(String, Object)}
	 * method.
	 * 
	 * @throws Exception
	 *             If an error occurs.
	 */
	@Test
	public void testRegisterService() throws Exception {
        when(bundleContextMock.registerService(anyString(), any(), anyString())).thenReturn(serviceRegistrationMock);
        mockStatic(IdGenerator.class);
        when(IdGenerator.generateNewId()).thenReturn(1001L);

        assertThat(tested.registerService("test", new Object()), is(1001L));

        verify(bundleContextMock).registerService(anyString(), any(), anyString());
        PowerMockito.verifyStatic();
        IdGenerator.generateNewId();

        Map<Long, ServiceRegistration> serviceRegistrations = (Map<Long, ServiceRegistration>) Whitebox.getInternalState(tested, "serviceRegistrations");
        assertThat(serviceRegistrations.get(1001L), is(serviceRegistrationMock));
	}

	/**
	 * Test for the {@link ServiceRegistrator#unregisterService(long)} method.
	 * 
	 * @throws Exception
	 *             If an error occurs.
	 */
	@Test
	public void testUnregisterService() throws Exception {
        Map<Long, ServiceRegistration> serviceRegistrations = new HashMap<Long, ServiceRegistration>();
        serviceRegistrations.put(1002L, serviceRegistrationMock);
        Whitebox.setInternalState(tested, "serviceRegistrations", serviceRegistrations);
        doNothing().when(serviceRegistrationMock).unregister();

        tested.unregisterService(1002L);

        verify(serviceRegistrationMock).unregister();
    }

	/**
	 * Test for the {@link ServiceRegistrator#unregisterService(long)} method
	 * when the ID doesn't exist.
	 * 
	 * @throws Exception
	 *             If an error occurs.
	 */
	@Test(expected = IllegalStateException.class)
	public void testUnregisterService_idDoesntExist() throws Exception {
        tested.unregisterService(1002L);
    }
}
