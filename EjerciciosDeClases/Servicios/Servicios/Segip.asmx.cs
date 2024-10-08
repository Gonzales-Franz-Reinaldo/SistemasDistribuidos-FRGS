using Servicios.Clases;
using Servicios.Database;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data.MySqlClient;

namespace Servicios
{
    /// <summary>
    /// Descripción breve de Segip
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Segip : System.Web.Services.WebService
    {
        
        [WebMethod]
        public string ConnectionDB()
        {
            // Crear instancia de la clase de conexión
            DatabaseConnection db = new DatabaseConnection();
            db.OpenConnection();

            // Puedes realizar más acciones aquí si lo deseas
            // Cerramos la conexión después de hacer la operación
            db.CerrarConexion();

            return "Conexión a la base de datos realizada correctamente.";
        }


        [WebMethod]
        public Persona BuscarPersonaCI(string numeroDocumentoCI)
        {
            DatabaseConnection db = new DatabaseConnection();
            db.OpenConnection();

            Persona persona = null;

            try
            {
                string sql = "SELECT * FROM persona WHERE ci = @ci";
                MySqlCommand mySqlCommand = new MySqlCommand(sql, db.GetConnection());
                mySqlCommand.Parameters.AddWithValue("@ci", numeroDocumentoCI);

                using (MySqlDataReader reader = mySqlCommand.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        persona = new Persona(
                            reader.GetInt32("id"),
                            reader.GetString("ci"),
                            reader.GetString("nombre"),
                            reader.GetString("primer_apellido"),
                            reader.GetString("segundo_apellido")
                        );
                    }
                }

            } 
            catch(Exception ex)
            {
                throw new Exception("Error al buscar a la persona: " +  ex.Message);
            }
            finally
            {
                db.CerrarConexion();
            }

            return persona;
        }


        [WebMethod]
        public Persona[] BuscarPersonas(string PrimerApellido, string SegundoApellido, string Nombres)
        {
            DatabaseConnection db = new DatabaseConnection();
            db.OpenConnection();    

            List<Persona> ListaPersonas = new List<Persona>();

            try
            {
                string sql = "SELECT * FROM persona WHERE primer_apellido = @primerApellido AND segundo_apellido = @segundoApellido AND nombre = @nombre";
                MySqlCommand command = new MySqlCommand(sql, db.GetConnection());

                command.Parameters.AddWithValue("@primerApellido", PrimerApellido);
                command.Parameters.AddWithValue("@segundoApellido", SegundoApellido);
                command.Parameters.AddWithValue("@nombre", Nombres);

                using(MySqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Persona persona = new Persona(
                            reader.GetInt32("id"),
                            reader.GetString("ci"),
                            reader.GetString("nombre"),
                            reader.GetString("primer_apellido"),
                            reader.GetString("segundo_apellido")
                        );

                        ListaPersonas.Add(persona);
                    }
                }
            }
            catch(Exception ex)
            {
                throw new Exception("Error al buscar personas: " + ex.Message);
            }
            finally
            {
                db.CerrarConexion();
            }

            return ListaPersonas.ToArray();
        }
    }

}
