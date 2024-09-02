/*
Descripción: Sistema de Gestión de Biblioteca simplificado
Autor: Jhosep
Fecha creación: 01 de septiembre del 2024, 02:25 pm
Fecha última modificación: 01 de septiembre del 2024, 07:26 pm
*/

// Clase base para materiales de la biblioteca
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase para libros
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

// Subclase para revistas
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

// Clase para usuarios
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz para operaciones de biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestar(material: Material, usuario: Usuario)
    fun devolver(material: Material, usuario: Usuario)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

// Clase principal de la biblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!prestamos.containsKey(usuario)) {
            prestamos[usuario] = mutableListOf()
        }
    }

    override fun prestar(material: Material, usuario: Usuario) {
        if (materialesDisponibles.remove(material)) {
            prestamos[usuario]?.add(material)
            println("Préstamo realizado: ${material.titulo} a ${usuario.nombre}")
        } else {
            println("Material no disponible")
        }
    }

    override fun devolver(material: Material, usuario: Usuario) {
        if (prestamos[usuario]?.remove(material) == true) {
            materialesDisponibles.add(material)
            println("Devolución realizada: ${material.titulo} de ${usuario.nombre}")
        } else {
            println("El usuario no tiene este material en préstamo")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("Warhammer 40,000: Codex Space Marines", "Games Workshop", 2023, "Ciencia ficción", 200)
    val revista1 = Revista("Game Informer", "Varios", 2024, "1067-6392", 340, 8, "GameStop")

    val usuario1 = Usuario("Juan", "Pérez", 30)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestar(libro1, usuario1)
    biblioteca.mostrarMaterialesReservados(usuario1)

    biblioteca.devolver(libro1, usuario1)
    biblioteca.mostrarMaterialesDisponibles()
}
