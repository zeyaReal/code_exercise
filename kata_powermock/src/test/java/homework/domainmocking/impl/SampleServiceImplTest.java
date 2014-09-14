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
package homework.domainmocking.impl;

import homework.domainmocking.EventService;
import homework.domainmocking.PersonService;
import homework.domainmocking.domain.BusinessMessages;
import homework.domainmocking.domain.Person;
import homework.domainmocking.domain.SampleServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * The purpose of this test is to get 100% coverage of the
 * {@link SampleServiceImpl} class without any code changes to that class. To
 * achieve this you need learn how to mock instantiation of domain objects.
 * <p>
 * While doing this tutorial please refer to the documentation on how to mock
 * construction of new objects at the PowerMock web site.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleServiceImpl.class)
public class SampleServiceImplTest {

	private SampleServiceImpl tested;
	private PersonService personServiceMock;
	private EventService eventService;

	@Before
	public void setUp() {
		personServiceMock = mock(PersonService.class);
        eventService = mock(EventService.class);

		tested = new SampleServiceImpl(personServiceMock, eventService);
	}

	@After
	public void tearDown() {
        // XXX 完成 Set all references to null or use the FieldDefaulter test listener
        // 注,FieldDefaulter方式是在类头定义@PowerMockListener(FieldDefaulter.class)以在测试完毕时自动把类属性置空
        // 可以阅读文章:http://code.google.com/p/powermock/source/browse/wiki/TestListeners.wiki?spec=svn1498&r=1498
		personServiceMock = null;
        eventService = null;
        tested = null;
	}

	@Test
	public void testCreatePerson() throws Exception {
        BusinessMessages businessMessages = mock(BusinessMessages.class);
        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        Person person = mock(Person.class);
        whenNew(Person.class).withArguments(anyString(),anyString()).thenReturn(person);
        doNothing().when(personServiceMock).create(person, businessMessages);

        when(businessMessages.hasErrors()).thenReturn(false);

        tested.createPerson("zhangfei","zhangyide");

        PowerMockito.verifyNew(BusinessMessages.class).withNoArguments();
        PowerMockito.verifyNew(Person.class).withArguments(anyString(),anyString());
        InOrder inOrder = Mockito.inOrder(personServiceMock, businessMessages);
        inOrder.verify(personServiceMock).create(person, businessMessages);
        inOrder.verify(businessMessages).hasErrors();
		}

	@Test
	public void testCreatePerson_error() throws Exception {
        BusinessMessages businessMessages = mock(BusinessMessages.class);
        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        Person person = mock(Person.class);
        whenNew(Person.class).withArguments(anyString(),anyString()).thenReturn(person);
        doNothing().when(personServiceMock).create(person, businessMessages);

        when(businessMessages.hasErrors()).thenReturn(true);
        doNothing().when(eventService).sendErrorEvent(person, businessMessages);

        tested.createPerson("zhangfei","zhangyide");

        PowerMockito.verifyNew(BusinessMessages.class).withNoArguments();
        PowerMockito.verifyNew(Person.class).withArguments(anyString(),anyString());
        InOrder inOrder = Mockito.inOrder(personServiceMock, businessMessages, eventService);
        inOrder.verify(personServiceMock).create(person, businessMessages);
        inOrder.verify(businessMessages).hasErrors();
        inOrder.verify(eventService);
	}

	@Test(expected = SampleServiceException.class)
	public void testCreatePerson_illegalName() throws Exception {
        BusinessMessages businessMessages = mock(BusinessMessages.class);
        whenNew(BusinessMessages.class).withNoArguments().thenReturn(businessMessages);
        whenNew(Person.class).withArguments(anyString(),anyString()).thenThrow(new IllegalArgumentException());

        tested.createPerson("zhangfei","zhangyide");
    }
}
