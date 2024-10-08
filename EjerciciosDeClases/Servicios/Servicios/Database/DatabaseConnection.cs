using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using MySql.Data.MySqlClient;
using System.Configuration;

namespace Servicios.Database
{
    public class DatabaseConnection
    {
        private MySqlConnection connection;

        public DatabaseConnection()
        {
            // Obtener la cadena de conexión desde el Web.config
            string conn = ConfigurationManager.ConnectionStrings["MySqlConnection"].ConnectionString;
            connection = new MySqlConnection(conn);
        }

        // Método para abrir la conexión
        public void OpenConnection()
        {

            if(connection.State == System.Data.ConnectionState.Closed)
            {
                connection.Open();
                Console.WriteLine("Conexión exitosa a la base de datos MySQL");
            }
        }

        // Método para cerrar la conexión
        public void CerrarConexion()
        {
            if (connection.State == System.Data.ConnectionState.Open)
            {
                connection.Close();
            }
        }

        // Método para obtener la conexión MySQL
        public MySqlConnection GetConnection()
        {
            return connection;
        }
    }
}