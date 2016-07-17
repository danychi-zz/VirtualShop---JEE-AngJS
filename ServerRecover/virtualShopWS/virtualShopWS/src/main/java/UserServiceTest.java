/*
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.validation.ValidationException;
 * 
 * import org.hibernate.service.spi.ServiceException; import org.junit.Before;
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.runners.MockitoJUnitRunner;
 * 
 * import pfc.virtualshopws.dao.UsersDao; import pfc.virtualshopws.dto.UsersDto;
 * import pfc.virtualshopws.service.UsersService;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class UserServiceTest {
 * 
 * private static final int userId = 1;
 * 
 * private static final String username = "dani"; private static final int phone
 * = 123456789; private static final String password = "1234"; private static
 * final String email = "danychi@gmail.com"; private static final String
 * lastName = "alarcon"; private static final String firstName = "dani"; private
 * static final String billingAddress = "jose de mora"; private static final int
 * dni = 1234; private static final String city = "baza"; private static final
 * String state = "spain"; private static final String postalCode = "18800";
 * 
 * private UsersDto dto;
 * 
 * @InjectMocks private UsersService service = new UsersService();
 * 
 * @Mock private UsersDao dao;
 * 
 * @Before public void prepare() throws ServiceException, ValidationException {
 * 
 * dto = new UsersDto(); dto.setEmail(email); ; dto.setPassword(password);
 * 
 * List<UsersDto> allUsers = new ArrayList<UsersDto>(); allUsers.add(dto);
 * 
 * // getTodosLosUsuarios when(dao.findAll()).thenReturn(allUsers);
 * 
 * // getUsuario when(dao.getUsuario(anyInt())).thenReturn(dto);
 * 
 * }
 * 
 * @Test public void testTodosLosUsuarios() throws ServiceException {
 * List<UsersDto> todosLosUsuarios = service.getTodosLosUsuarios();
 * 
 * Assert.assertNotNull(todosLosUsuarios);
 * Assert.assertTrue(todosLosUsuarios.size() > 0);
 * 
 * Assert.assertEquals(todosLosUsuarios.get(0).getApellido(), APELLIDO);
 * 
 * }
 * 
 * @Test public void testGetUsuario() throws ServiceException,
 * ValidationException { UsersDto uDto = service.getUsuario(4);
 * 
 * Assert.assertNotNull(uDto); Assert.assertEquals(uDto.getApellido(),
 * APELLIDO); Assert.assertEquals(uDto.getDni(), DNI);
 * Assert.assertEquals(uDto.getNombre(), NOMBRE);
 * Assert.assertTrue(uDto.getAnoNacimiento() == ANO_NACIMIENTO);
 * Assert.assertTrue(uDto.getId() == ID);
 * 
 * }
 * 
 * @Test(expected = ValidationException.class) public void testAddUsuario()
 * throws ServiceException, ValidationException {
 * 
 * service.addUsuario(new UsersDto()); }
 * 
 * @Test(expected = ValidationException.class) public void testDeleteUsuario()
 * throws ServiceException, ValidationException {
 * 
 * service.deleteUsuario(0); }
 * 
 * }
 */