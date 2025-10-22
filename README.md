# Inicio 
Este repositorio es acerca de una app hecha con Spring Boot en clases de Lógica para la solución de problemas, dictada por el profesor [Daniel Felipe Agudelo Molina](https://github.com/DanielDev87)


# ⚠️ Advertencía.
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

**INSERTAR IMAGEN DE EL FILE MANAGER**

3. Una vez tus archivos se vean de esa manera, podrás ejecutar Spring Boot de la siguiente manera: Verás que se creó un icono en forma de rombo con símbolo de encendido 
<img src="docs/images/encendido.png" alt="Encendido" width="30" style="vertical-align:middle;" />, click y entras a su menú, acto seguido ejecutas con el símbolo de dos flechas.

   3.1 Otra forma es irte a **appbank>src/main/java>com.logsoluprobl.appbank>AppBankApplication** Y al abrir el archivo arriba a la derecha verás también una fleca para ejecutar. (F5 - Atajo por defecto)

4. Una vez ejecutado veras en la terminal "SPRING" en ASCII Art. Puedes probar en tu navegador escribir *htpp:localhost:8080/* Si ves **Whitelabel Error Page** no te preocupes, es normal. Es una página para verificar su arranque en caso de no encontrar ruta.

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

## 👨‍🦲 Customers

`localhost:8080/api/bank/customers` > Consultas o creas un cliente dependiendo del metodo usado (GET) sin especificar **Id** mostrará todos los clientes.

`localhost:8080/api/bank/customers/id` > Consultas un cliente con su id

(IMAGEN DE GetAllCustomers.png) 

## 🪪 Accounts.

`localhost:8080/api/bank/customers/1/accounts` > Crear una cuenta bancaria de tipo **SAVINGS** o **CHECKING** asociada a un cliente en este caso el cliente con Id:**1**

Para Savings: parameter se interpreta como tasa de interés (interestRate).

Para Checking: parameter se interpreta como límite de sobregiro (overdraftLimit).

Ejemplo JSON:

{
  "type": "SAVINGS",
  "accountId": "Ac1",
  "parameter": 0.05
}

(IMAGEN DE CreateAccount.png)

`localhost:8080/api/bank/accounts/Ac2` > Consulta cuentas por id, en este caso "Ac2" o el valor que tu le agregues.

En este caso esta cuenta está asociada al cliente 2.

(IMAGEN CON LA PRUEBA DE AccountById.png)


`localhost:8080/api/bank/accounts/Ac1/deposit?amount=5000` > Deposita dinero a la cuenta con Id: **Ac1** y cantidad 5000 (Prueba a cambiar estos valores y con GET (Anterior metodo) mirar el cámbio.

Esto soltará un valor `true` en caso de que si deposite y `false` en caso de que no deposite.

(IMAGEN DE DepositImage.png)

`localhost:8080/api/bank/accounts/Ac1/withdraw?amount=2500` > Retira dinero a la cuenta con Id: **Ac1** y cantidad 2500.

(IMAGEN DE WithdrawImage.png)


`localhost:8080/api/bank/accounts/Ac1/transfer` > Transfiere dinero. En este caso va a transferir de la cuenta con Id: **Ac1** a la cuenta "Ac2". 

(IMAGEN DE TransferImage.png)

## 💸 Transactions
