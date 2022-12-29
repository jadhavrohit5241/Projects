<<<<<<< HEAD:pcmjwt/src/main/java/com/te/pcmjwt/service/ServiceInterface.java
package com.te.pcmjwt.service;
=======
package com.te.pcmjwt.service.serviceinterface;
>>>>>>> e6387db5ba6721c91b187c2dd7f4a5327ea6ffa4:pcmjwt/src/main/java/com/te/pcmjwt/service/serviceInterface/ServiceInterface.java

import java.util.List;
import java.util.Optional;

import com.te.pcmjwt.dto.AssignRoleDto;
import com.te.pcmjwt.dto.EmployeeRegisterDto;
import com.te.pcmjwt.dto.GetAllEmployeeDto;

public interface ServiceInterface {

	boolean register(EmployeeRegisterDto employeeRegisterDto);

	Optional<List<GetAllEmployeeDto>> getAllEmployee();

	boolean assignRole(AssignRoleDto assignRoleDto);

}
