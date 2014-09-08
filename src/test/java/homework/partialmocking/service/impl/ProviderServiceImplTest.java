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
import homework.partialmocking.dao.domain.impl.ServiceArtifact;
import homework.partialmocking.domain.DataProducer;
import homework.partialmocking.domain.ServiceProducer;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

/**
 * The purpose of this test is to get 100% coverage of the
 * {@link ProviderServiceImpl} class without any code changes to that class. To
 * achieve this you need learn how to create partial mocks, modify internal
 * state, invoke and expect private methods.
 * <p/>
 * While doing this tutorial please refer to the documentation on how to expect
 * private methods and bypass encapsulation at the PowerMock web site.
 */
@RunWith(PowerMockRunner.class)

@PrepareForTest({ProviderServiceImpl.class, ProviderDao.class, ServiceProducer.class, ServiceArtifact.class})

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

//	@Test
//	public void testGetAllServiceProviders() throws Exception {
//        HashSet<ServiceProducer> allServiceProduces = new HashSet<>();
//        ServiceProducer serviceProducer = mock(ServiceProducer.class);
//        allServiceProduces.add(serviceProducer);
//        when(tested,"getAllServiceProducers").thenReturn(allServiceProduces);
//
//        assertThat(tested.getAllServiceProviders(), Is.<Set<ServiceProducer>>is(allServiceProduces));
//
//        verifyPrivate(tested).invoke("getAllServiceProducers");
//	}

    @Test
    public void testGetAllServiceProviders_noServiceProvidersFound() throws Exception {
//        Set<ServiceProducer> allServiceProduces = Collections.emptySet();
        ProviderServiceImpl tested = PowerMockito.spy(new ProviderServiceImpl());
//        PowerMockito.when(tested.getAllServiceProducers()).thenReturn(null);
        PowerMockito.doReturn(null).when(tested).getAllServiceProducers();
//        PowerMockito.when(tested,"getAllServiceProducers").thenReturn(null);
//        PowerMockito.when(tested, method(ProviderServiceImpl.class, "getAllServiceProducers")).withNoArguments().thenReturn(null);

        tested.getAllServiceProviders();
        assertThat(tested.getAllServiceProviders(), Matchers.empty());

//        PowerMockito.verifyPrivate(tested).invoke("getAllServiceProducers");
    }

    //	@Test
//	public void testServiceProvider_found() throws Exception {
//        HashSet<ServiceProducer> allServiceProduces = new HashSet<>();
//        ServiceProducer serviceProducer = mock(ServiceProducer.class);
//        when(serviceProducer.getId()).thenReturn(12);
//        allServiceProduces.add(serviceProducer);
//        PowerMockito.when(tested, method(ProviderServiceImpl.class, "getAllServiceProducers")).withNoArguments().thenReturn(allServiceProduces);
//
//        assertThat(tested.getServiceProvider(12), is(serviceProducer));
//
//        verifyPrivate(tested).invoke("getAllServiceProducers");
//        Mockito.verify(serviceProducer).getId();
//	}
//
//	@Test
//	public void testServiceProvider_notFound() throws Exception {
//        HashSet<ServiceProducer> allServiceProduces = new HashSet<>();
//        ServiceProducer serviceProducer = mock(ServiceProducer.class);
//        when(serviceProducer.getId()).thenReturn(12);
//        allServiceProduces.add(serviceProducer);
//        PowerMockito.when(tested,"getAllServiceProducers").thenReturn(allServiceProduces);
//
//        assertThat(tested.getServiceProvider(11), null);
//
//        verifyPrivate(tested).invoke("getAllServiceProducers");
//        Mockito.verify(serviceProducer).getId();
//	}
//
    @Test
    public void getAllServiceProducers2() throws Exception {
        ServiceArtifact serviceArtifact = mock(ServiceArtifact.class);
        HashSet<ServiceArtifact> serviceArtifacts = new HashSet<ServiceArtifact>();
        serviceArtifacts.add(serviceArtifact);
        when(providerDaoMock.getAllServiceProducers()).thenReturn(serviceArtifacts);
        when(serviceArtifact.getId()).thenReturn(1);
        when(serviceArtifact.getName()).thenReturn("name1");
        DataProducer[] dataProducers = new DataProducer[0];
//        dataProducers[0] = new DataProducer(1,"name1");
        when(serviceArtifact.getDataProducers()).thenReturn(dataProducers);
        //XXX 这里的模拟构造函数后面再看看
//        ServiceProducer serviceProducer = mock(ServiceProducer.class);
//        whenNew(ServiceProducer.class).withArguments(1,"name1",dataProducers).thenReturn(serviceProducer);
        ServiceProducer serviceProducer = new ServiceProducer(1, "name1", dataProducers);


        Set<ServiceProducer> resultServiceProducers = Whitebox.invokeMethod(tested, "getAllServiceProducers");

        assertThat(resultServiceProducers.size(), is(1));
        assertThat(resultServiceProducers, contains(serviceProducer));
    }

    @Test
    public void getAllServiceProducers_empty() throws Exception {
        HashSet<ServiceArtifact> serviceArtifacts = new HashSet<ServiceArtifact>();
        when(providerDaoMock.getAllServiceProducers()).thenReturn(serviceArtifacts);

        Set<ServiceProducer> resultServiceProducers = Whitebox.invokeMethod(tested, "getAllServiceProducers");

        assertThat(resultServiceProducers, Matchers.empty());

        Mockito.verify(providerDaoMock).getAllServiceProducers();
    }
}
