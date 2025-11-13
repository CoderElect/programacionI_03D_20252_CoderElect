# Manual de Usuario — Segurcol

##  Descripción general

**Segurcol** está desarrollada en **JavaFX** lo que permite gestionar los recursos de una empresa de seguridad privada: empleados, servicios, equipos y agenda de novedades.

Su interfaz es intuitiva y está organizada por módulos para facilitar la administración de cada elemento.

---

##  Pantalla principal

Al iniciar la aplicación, se abre la **Ventana Principal**, donde se encuentran los siguientes botones:

| Botón | Función |
|-------|----------|
| **Personal** | Abre la ventana para gestionar empleados (vigilantes, supervisores y operadores). |
| **Servicios** | Permite registrar, consultar o editar los servicios prestados por la empresa. |
|  **Equipos** | Muestra el inventario de equipos, su estado, tipo y valor de reposición. |
| ️ **Agenda** | Gestiona novedades, horarios y asignaciones diarias. |

---

##  Gestión de Empleados

### Submenú de Empleados

Al presionar **Personal**, se abre una ventana con tres opciones:

| Tipo de empleado | Descripción |
|------------------|-------------|
| **Vigilantes** | Empleados encargados de la vigilancia física. |
| **Supervisores** | Encargados del control de turnos y supervisión. |
| **Operadores de Monitoreo** | Personal que gestiona la vigilancia electrónica y cámaras. |

Cada tipo de empleado tiene su propio formulario CRUD (Crear, Leer, Actualizar, Eliminar).

---

### Formulario CRUD de Empleado

El formulario contiene campos básicos como:

- **Código del empleado**
- **Nombre completo**
- **Cédula**
- **Teléfono**
- **Tipo de contrato**
- **Servicio asignado**
- **Estado (Activo / Inactivo)**

#### 🔘 Botones principales:

| Botón                  | Acción |
|------------------------|--------|
| **Agregar**            | Registra un nuevo empleado. |
| **Actualizar**         | Permite modificar los datos de un empleado seleccionado. |
|  **Eliminar**          | Elimina el empleado de la base de datos. |

---

##  Gestión de Equipos

En esta ventana se muestran los equipos utilizados por los empleados.

### Columnas de la tabla:

| Campo | Descripción |
|-------|--------------|
| **Código** | Identificador único del equipo. |
| **Valor de reposición** | Costo de reemplazo del equipo. |
| **Estado** | Disponible / En uso / Dañado. |
| **Tipo** | Tipo de equipo (radio, uniforme, arma, etc). |
| **Servicio asignado** | Servicio donde se usa el equipo. |
| **Empleado asignado** | Empleado responsable del equipo. |

#### Acciones disponibles:
- **Agregar nuevo equipo**
- **Editar información**
- **Eliminar registro**
- **Asignar servicio** Una vez seleccionado el empleado, se añade el servicio.
- **Asignar empleado** 

---

##  Gestión de Servicios

Permite administrar los servicios ofrecidos por la empresa.

Cada servicio incluye:

- **Código del servicio**
- **Tipo de servicio** (Custodia fija, Patrullaje móvil, Monitoreo)
- **Cliente**
- **Dirección**
- **Empleado responsable**
- **Equipos asignados**

---

##  Agenda y Novedades

Este módulo permite registrar eventos o situaciones diarias:

- **Turnos programados**
- **Novedades**
- **Asignaciones temporales**

---

## Configuración técnica

| Elemento | Descripción |
|-----------|-------------|
| **Arquitectura** | MVC (Modelo – Vista – Controlador) |
| **Archivos FXML** | Se encuentran en `src/main/resources/co/edu/uniquindio/poo/segurcoljfx/view/` |
| **Controladores** | En el paquete `viewController` |
| **Modelo de datos** | En el paquete `model` |

---
## Thank you 
