using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Servicios.Clases
{
    public class Persona
    {
        public int Id { get; set; }
        public string CI { get; set; }
        public string Nombre { get; set; }
        public string PrimerApellido { get; set; }
        public string SegundoApellido { get; set; }


        // Constructor vacío (necesario para serialización)
        public Persona()
        {
        }

        // Constructor con parámetros
        public Persona(int id, string ci, string nombre, string primerApellido, string segundoApellido) 
        {
            Id = id;
            CI = ci;
            Nombre = nombre;
            PrimerApellido = primerApellido;
            SegundoApellido = segundoApellido;
        }

    }
}