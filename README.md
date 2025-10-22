# Inicio 
Este repositorio es acerca de una app hecha con Spring Boot en clases de Lógica para la solución de problemas, dictada por el profesor [Daniel Felipe Agudelo Molina](https://github.com/DanielDev87)


## ⚠️ Advertencía.
Antes de instalar o ejecutar.
Necesitas descargar e instalar ciertos programás para su correcto funcionamiento.

✅ **Programás**
- JDK 17 o superior. Puedes instalarlo [aquí](https://www.oracle.com/java/technologies/downloads/)
- [Visual Studio Code ](https://code.visualstudio.com/)

📦 **Extensiones**

Dentro de Visual Studio Code puedes instalar extensiones que serán necesarias para su funcionamiento. 
Para acceder al menu presiona Crtl + Shift + X (El atajo por defecto).
- [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client)
- [Extension Pack For Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

## Funcionamiento

1. Lo primero que se realiza es la descarga de los archivos del repositorio; para eso puedes ir a el botón verde **"<>Code"** y descargar el **.Zip**
2. Una vez descargado se extrae, vas a Visual Studio Code y En **File** seleccionas **Open Folder**, buscas la carpeta donde extraiste el **.Zip** y seleccionas **Deberías ver algo como lo siguiente.**

❗ Aviso: Es recomendable en el **File Manager o el explorador de archivos** seleccionar **JAVA PROJECTS** al instalar el plugin [Extension Pack For Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) verás como se crea.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/ExplorerImage.png" alt="Explorer" width="20%"/>

3. Una vez tus archivos se vean de esa manera, podrás ejecutar Spring Boot de la siguiente manera: Verás que se creó un icono en forma de rombo con símbolo de encendido 
<img src="docs/images/encendido.png" alt="Encendido" width="30" style="vertical-align:middle;" />, click y entras a su menú, acto seguido ejecutas con el símbolo de dos flechas.

   3.1 Otra forma es irte a **appbank > src/main/java > com.logsoluprobl.appbank > AppBankApplication** Y al abrir el archivo arriba a la derecha verás también una flecha para ejecutar. (F5 - Atajo por defecto)

4. Una vez ejecutado veras en la terminal "SPRING" en ASCII Art. Puedes probar en tu navegador escribir *htpp:localhost:8080/* Si ves **Whitelabel Error Page** no te preocupes, es normal. Es una página para verificar su arranque en caso de no encontrar ruta.

En caso de que no sea 8080 el puerto y no conecte. En la terminal donde aparece el ASCII Art te dirá en que puerto se inicializó.


6. Para solucionar ese error, puedes leer el codigo de **BankController** y ver que rutas existen.
   Ten encuenta que todas inician con **/api/bank** y continuan respectivamente con lo que desees (Siempre que esté en el codigo).
   **Ejemplo:** `http:localhost:8080/api/bank/customers` | Esta ruta te mostrará todos los clientes creados.

7. Insertar datos mediante [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client)
  Para insertar datos con Thunder Client deberás abrirlo mediante su icono con un rayo con contorno circular. <img src="docs/images/thunder.png" alt="Thunder" width="30" style="vertical-align:middle;" />

A continuación presionar el botón azul **New Request** 

Te pedirá una URL, por defecto te entrega https://www.thunderclient.com/welcome, borrala. Y prueba con: `localhost:8080/api/bank/customers`

No sin antes cambiar el metodo **GET** (Obtener) por **POST** (Subir). Seleccionar Body y escribir un archivo **JSON**. y enviar.

Ejemplo: 
{
  "id": "1",
  "name": "nombreejemplo",
  "email": "ejemplo@gmail.com"
}

Para obtener datos en este caso lo único que tendrás que hacer es cambiar **POST** a **GET**.


---

# Todas las rutas de la App.

⚠️ Importante.

Puedes, para no hacer todos los metodos en una sola **Request**, duplicar o crear una nueva y cambiarle el nombre. Te quedará algo así.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/RequestMethodsImage.png" style="width:20%;" alt="RequestMethodsImage">


## 👨‍🦲 Customers

`localhost:8080/api/bank/customers` > Consultas o creas un cliente dependiendo del método usado (GET). Sin especificar Id mostrará todos los clientes.

`localhost:8080/api/bank/customers/id` > Consulta un cliente con su id.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/GetAllCustomers.png" style="width:20%;" alt="GetAllCustomers">


## 🪪 Accounts

`localhost:8080/api/bank/customers/1/accounts` > Crear una cuenta bancaria de tipo SAVINGS o CHECKING asociada a un cliente (cliente con Id: 1).

Para Savings: parameter se interpreta como tasa de interés (interestRate).
Para Checking: parameter se interpreta como límite de sobregiro (overdraftLimit).

Ejemplo JSON:

{
"type": "SAVINGS",
"accountId": "Ac1",
"parameter": 0.05
}

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/CreateAccount.png" style="width:20%;" alt="CreateAccount">

`localhost:8080/api/bank/accounts/Ac2` > Consulta cuentas por id, en este caso "Ac2" o el valor que le agregues.
Esta cuenta está asociada al cliente 2.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/AccountById.png" style="width:20%;" alt="AccountById">

`localhost:8080/api/bank/accounts/Ac1/deposit?amount=5000` > Deposita dinero a la cuenta con Id: Ac1 y cantidad 5000.
Esto devuelve true si se depositó correctamente, false si no.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/DepositImage.png" style="width:20%;" alt="DepositImage">

`localhost:8080/api/bank/accounts/Ac1/withdraw?amount=2500` > Retira dinero de la cuenta con Id: Ac1 y cantidad 2500.

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/WithdrawImage.png" style="width:20%;" alt="WithdrawImage">

`localhost:8080/api/bank/accounts/Ac1/transfer` > Transfiere dinero de la cuenta con Id: Ac1 a otra cuenta (por ejemplo, "Ac2").

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/TransferImage.png" style="width:20%;" alt="TransferImage">

## 💸 Transactions

`localhost:8080/api/bank/accounts/Ac1/transactions` > Muestra todas las transaciones de una cuenta con Id en este caso: **Ac1**

<img src="https://raw.githubusercontent.com/DavidMrn/logic_app_bank/refs/heads/main/docs/images/TransactionsImage.png" style="width:20%;" alt="TrasactionsImage">

`localhost:8080/api/bank/accounts/Ac3/apply-interest` > Aplica interes a una cuenta por Id. En este caso **Ac3**. Devuelve HttpStatus como OK 200 en caso de ser aplicable.

---

`localhost:8080/api/bank/customers/2/accounts` > Obtiene todas las cuentas de un cliente por su id. En este caso: **2**

**❗Todas estas rutas se pueden copiar y visualizar en el navegador después de ejecutarlas en Thunder Client**
