# Aries Remote Service Admin Examples - OSGi Remote µServices
[![SMC Tech Blog](https://img.shields.io/badge/Mainteiner-SMC%20Tech%20Blog-blue)](https://techblog.smc.it) [![Twitter Follow](https://img.shields.io/twitter/follow/SMCpartner.svg?style=social&label=%40SMCpartner%20on%20Twitter&style=plastic)](https://twitter.com/SMCpartner) 

This project refers to the article [What are OSGi Remote µServices published](https://techblog.smc.it/it/2020-07-31/cosa-sono-osgi-remote-services) 
on the SMC [TechBlog](https://techblog.smc.it) blog.

In this project there are the three OSGi API, Consumer and Service bundles for 
the Who I am service. Details are shown in the table.

| Service              | Bundle Name     | Description                                                  |
| -------------------- | --------------- | ------------------------------------------------------------ |
| Who I am Service     | WhoIam API      | Bundle that defines the Who I am service contract through the Java interface. The bundle exports the interface package |
|                      | WhoIam Service  | Bundle that implements the interface of the Who I am service. The bundle imports the interface package |
|                      | WhoIam Consumer | Bundle that consumes the Who I am service. The reference to the service is obtained transparently from the Service Registry. The bundle imports the interface package |

Table 1 - OSGi bundles that will implement the example scenario for Remote µServices


## 1. Quick Start

```bash
$ git clone https://github.com/smclab/aries-rsa-whoiam-examples.git
$ cd aries-rsa-whoiam-examples
$ mvn package
```

In this terminal session you will see the clone of the repository and 
compilation of the project. Next you will see the connection to the console of 
Liferay from which I will execute commands to obtain information about Who I am
service, all this is possible thanks to the call to remote services 
(OSGi Remote µServices).

[![asciicast](https://asciinema.org/a/351307.svg)](https://asciinema.org/a/351307?autoplay=1)


## Contributing
Pull requests are welcome. For major changes, please open an issue first to 
discuss what you would like to change.

Please make sure to update tests as appropriate.


## License

Without specific disclaimer, all the plugins inside this repositories are free
software ("Licensed Software"); you can redistribute it and/or modify it under
the terms of the [GNU Lesser General Public License](http://www.gnu.org/licenses/lgpl-2.1.html)
as published by the Free Software Foundation; either version 2.1 of the License,
or (at your option) any later version.

These plugins are distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; including but not limited to, the implied warranty of MERCHANTABILITY,
NONINFRINGEMENT, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
Public License for more details.

You should have received a copy of the [GNU Lesser General Public
License](http://www.gnu.org/licenses/lgpl-2.1.html) along with this library; if
not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
Floor, Boston, MA 02110-1301 USA