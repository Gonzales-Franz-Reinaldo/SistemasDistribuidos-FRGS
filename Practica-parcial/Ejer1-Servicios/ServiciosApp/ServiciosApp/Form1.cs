using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Net.Http;
//Install - Package System.Text.Json -> Instalar paquete para usar System.Text.Json
using System.Text.Json;

//using Newtonsoft.Json;
//Install - Package Newtonsoft.Json

namespace ServiciosApp
{
    public partial class Form1 : Form
    {
        private readonly HttpClient client;

        private const string urlRest = "http://localhost:8000/api/pronosticos";
        private const string urlGraphQL = "http://localhost:4000/graphql/pronostico";
        public Form1()
        {
            InitializeComponent();

            client = new HttpClient();
        }

        private async void btnEjecutar_Click(object sender, EventArgs e)
        {
            try
            {
                listResultado.Items.Clear();

                string tipoServicio = comboTipoService.SelectedItem.ToString();
                string tipoOperacion = comboTipoOperacion.SelectedItem.ToString();

                switch (tipoOperacion)
                {
                    case "Listar":
                        await ListarPronosticos(tipoServicio);
                        break;
                    case "Insertar":
                        // Implementar
                        await InsertarPronostico(tipoServicio);
                        break;
                    case "Actualizar":
                        // Implementar
                        await ActualizarPronostico(tipoServicio);
                        break;
                    case "Eliminar":
                        // Implementar
                        await EliminarPronostico(tipoServicio);
                        break;
                    case "Buscar":
                        // Implementar
                        await BuscarPronostico(tipoServicio);
                        break;
                    default:
                        MessageBox.Show("Seleccione una operación válida.");
                        break;
                }
            } catch(Exception ex)
            {
                listResultado.Items.Add("Error: " + ex.Message);
                labelStatus.Text = "Error al ejecutar la operación";
            }
        }

        // METODOS DE OPERACIONES REST Y GRAPHQL
        public async Task ListarPronosticos(string tipoServicio)
        {
            listResultado.Items.Clear();

            if (tipoServicio == "Rest")
            {
                try
                {
                    var response = await client.GetAsync(urlRest);

                    if (response.IsSuccessStatusCode)
                    {
                        // Leemos la respuesta como una cadena
                        var content = await response.Content.ReadAsStringAsync();

                        // Deserializamos la cadena a un objeto
                        var pronosticos = JsonSerializer.Deserialize<List<Pronostico>>(content);

                        foreach (var pronostico in pronosticos)
                        {
                            listResultado.Items.Add(
                                 $"ID: {pronostico.id}, Fecha: {pronostico.fecha}, Temperatura: {pronostico.temperatura}"
                            );
                        }

                        labelStatus.Text = "Pronósticos listados";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al listar pronósticos";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al listar pronósticos";
                }
            }
            else if (tipoServicio == "GraphQL")
            {
                try
                {
                    var query = new
                    {
                        query = "{ allPronosticos { id fecha temperatura } }"
                    };

                    // Serializamos la consulta y la enviamos como contenido JSON
                    var content = new StringContent(JsonSerializer.Serialize(query), Encoding.UTF8, "application/json");
                    var response = await client.PostAsync(urlGraphQL, content);

                    if(response.IsSuccessStatusCode)
                    {
                        // Leemos la respuesta como una cadena
                        var result = await response.Content.ReadAsStringAsync();

                        // Parseamos el JSON de la respuesta
                        var json = JsonDocument.Parse(result);
                        var pronosticos = json.RootElement.GetProperty("data").GetProperty("allPronosticos");

                        foreach(var pronostico in pronosticos.EnumerateArray())
                        {
                            listResultado.Items.Add(
                                $"ID: {pronostico.GetProperty("id").GetInt32()}, " +
                                $"Fecha: {pronostico.GetProperty("fecha").GetString()}, " +
                                $"Temperatura: {pronostico.GetProperty("temperatura").GetDouble()}"
                            );
                        }

                        labelStatus.Text = "Pronósticos listados";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al listar pronósticos";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al listar pronósticos";
                }
            }
        }


        public async Task InsertarPronostico(string tipoServicio)
        {
            // Implementar
            listResultado.Items.Clear();

            string fecha = textFecha.Text;
            double temperatura = Convert.ToDouble(textTemperatura.Text);

            if (tipoServicio == "Rest")
            {
                try
                {

                    var data = new
                    {
                        fecha = fecha,
                        temperatura = temperatura
                    };

                    StringContent content = new StringContent(JsonSerializer.Serialize(data), Encoding.UTF8, "application/json");
                    var response = await client.PostAsync(urlRest, content);

                    if (response.IsSuccessStatusCode)
                    {
                        string result = await response.Content.ReadAsStringAsync();

                        var pronostico = JsonSerializer.Deserialize<Pronostico>(result);

                        listResultado.Items.Add(
                            $"ID: {pronostico.id}, Fecha: {pronostico.fecha}, Temperatura: {pronostico.temperatura}"
                        );

                        labelStatus.Text = "Pronóstico insertado por Rest";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al insertar pronóstico";

                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al insertar pronóstico";
                }
            }
            else if (tipoServicio == "GraphQL")
            {
                var mutation = new
                {
                    query = $"mutation {{ createPronostico(fecha: \"{fecha}\", temperatura: {temperatura}) {{ id fecha temperatura }} }}"
                };

                StringContent content = new StringContent(JsonSerializer.Serialize(mutation), Encoding.UTF8, "application/json");

                try
                {
                    var response = await client.PostAsync(urlGraphQL, content);

                    if (response.IsSuccessStatusCode)
                    {
                        string result = await response.Content.ReadAsStringAsync();

                        var json = JsonDocument.Parse(result);
                        var pronostico = json.RootElement.GetProperty("data").GetProperty("createPronostico");

                        listResultado.Items.Add(
                            $"ID: {pronostico.GetProperty("id").GetInt32()}, " +
                            $"Fecha: {pronostico.GetProperty("fecha").GetString()}, " +
                            $"Temperatura: {pronostico.GetProperty("temperatura").GetDouble()}"
                        );

                        labelStatus.Text = "Pronóstico insertado por GraphQL";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al insertar pronóstico";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al insertar pronóstico";
                }

            }else
             {
                listResultado.Items.Add("Error: Tipo de servicio no válido");
                labelStatus.Text = "Error al insertar pronóstico";
             }
        }

        public async Task ActualizarPronostico(string tipoServicio)
        {
            // Implementar
            listResultado.Items.Clear();

            string fecha = textFecha.Text;
            double temperatura = Convert.ToDouble(textTemperatura.Text);

            if (tipoServicio == "Rest")
            {
                var data = new
                {
                    fecha = fecha,
                    temperatura = temperatura
                };

                StringContent content = new StringContent(JsonSerializer.Serialize(data), Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.PutAsync(urlRest + "/" + fecha, content);

                if (response.IsSuccessStatusCode)
                {
                    string result = await response.Content.ReadAsStringAsync();

                    var pronostico = JsonSerializer.Deserialize<Pronostico>(result);

                    listResultado.Items.Add(
                        $"ID: {pronostico.id}, Fecha: {pronostico.fecha}, Temperatura: {pronostico.temperatura}"
                    );

                    labelStatus.Text = "Pronóstico actualizado por Rest";
                }
                else
                {
                    listResultado.Items.Add("Error: " + response.StatusCode);
                    labelStatus.Text = "Error al actualizar pronóstico";
                }
            }
            else if (tipoServicio == "GraphQL")
            {
                var mutation = new
                {
                    query = $"mutation {{ updatePronostico(fecha: \"{fecha}\", temperatura: {temperatura}) {{ id fecha temperatura }} }}"
                };

                StringContent content = new StringContent(JsonSerializer.Serialize(mutation), Encoding.UTF8, "application/json");

                try
                {
                    HttpResponseMessage response = await client.PostAsync(urlGraphQL, content);

                    if (response.IsSuccessStatusCode)
                    {
                        string result = await response.Content.ReadAsStringAsync();

                        var json = JsonDocument.Parse(result);
                        var pronostico = json.RootElement.GetProperty("data").GetProperty("updatePronostico");

                        listResultado.Items.Add(
                            $"ID: {pronostico.GetProperty("id").GetInt32()}, " +
                            $"Fecha: {pronostico.GetProperty("fecha").GetString()}, " +
                            $"Temperatura: {pronostico.GetProperty("temperatura").GetDouble()}"
                        );

                        labelStatus.Text = "Pronóstico actualizado por GraphQL";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al actualizar pronóstico";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al actualizar pronóstico";
                }
            }
            else
            {
                listResultado.Items.Add("Error: Tipo de servicio no válido");
                labelStatus.Text = "Error al actualizar pronóstico";
            }
        }

        public async Task EliminarPronostico(string tipoServicio)
        {
            // Implementar
            listResultado.Items.Clear();

            string fecha = textFecha.Text;

            if (tipoServicio == "Rest")
            {
                HttpResponseMessage response = await client.DeleteAsync(urlRest + "/" + fecha);

                if (response.IsSuccessStatusCode)
                {
                    listResultado.Items.Add("Pronóstico eliminado por Rest");
                    labelStatus.Text = "Pronóstico eliminado por Rest";
                }
                else
                {
                    listResultado.Items.Add("Error: " + response.StatusCode);
                    labelStatus.Text = "Error al eliminar pronóstico";
                }
            }
            else if (tipoServicio == "GraphQL")
            {
                var mutation = new
                {
                    query = $"mutation {{ deletePronostico(fecha: \"{fecha}\") {{ id fecha temperatura }} }}"
                };

                StringContent content = new StringContent(JsonSerializer.Serialize(mutation), Encoding.UTF8, "application/json");

                try
                {
                    HttpResponseMessage response = await client.PostAsync(urlGraphQL, content);

                    if (response.IsSuccessStatusCode)
                    {
                        listResultado.Items.Add("Pronóstico eliminado por GraphQL");
                        labelStatus.Text = "Pronóstico eliminado por GraphQL";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al eliminar pronóstico";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al eliminar pronóstico";
                }

            } else if(tipoServicio == "GraphQL")
            {

            }
            else
            {
                listResultado.Items.Add("Error: Tipo de servicio no válido");
                labelStatus.Text = "Error al eliminar pronóstico";
            }
        }

        public async Task BuscarPronostico(string tipoServicio)
        {
            // Implementar
            listResultado.Items.Clear();

            string fecha = textFecha.Text;

            if (tipoServicio == "Rest")
            {
                HttpResponseMessage response = await client.GetAsync(urlRest + "/" + fecha);

                if (response.IsSuccessStatusCode) {

                    string result = await response.Content.ReadAsStringAsync();

                    var pronostico = JsonSerializer.Deserialize<Pronostico>(result);

                    listResultado.Items.Add(
                        $"ID: {pronostico.id}, Fecha: {pronostico.fecha}, Temperatura: {pronostico.temperatura}"
                    );

                    labelStatus.Text = "Pronóstico encontrado por Rest";
                }
                else
                {
                    listResultado.Items.Add("Error: " + response.StatusCode);
                    labelStatus.Text = "Error al buscar pronóstico";
                }
            }
            else if (tipoServicio == "GraphQL")
            {
                var query = new
                {
                    query = $"{{ pronostico(fecha: \"{fecha}\") {{ id fecha temperatura }} }}"
                };

                StringContent content = new StringContent(JsonSerializer.Serialize(query), Encoding.UTF8, "application/json");

                try
                {
                    HttpResponseMessage response = await client.PostAsync(urlGraphQL, content);

                    if (response.IsSuccessStatusCode)
                    {
                        string result = await response.Content.ReadAsStringAsync();

                        var json = JsonDocument.Parse(result);
                        var pronostico = json.RootElement.GetProperty("data").GetProperty("pronostico");

                        listResultado.Items.Add(
                            $"ID: {pronostico.GetProperty("id").GetInt32()}, " +
                            $"Fecha: {pronostico.GetProperty("fecha").GetString()}, " +
                            $"Temperatura: {pronostico.GetProperty("temperatura").GetDouble()}"
                        );

                        labelStatus.Text = "Pronóstico encontrado por GraphQL";
                    }
                    else
                    {
                        listResultado.Items.Add("Error: " + response.StatusCode);
                        labelStatus.Text = "Error al buscar pronóstico";
                    }
                }
                catch (Exception ex)
                {
                    listResultado.Items.Add("Error: " + ex.Message);
                    labelStatus.Text = "Error al buscar pronóstico";
                }

            }
            else
            {
                listResultado.Items.Add("Error: Tipo de servicio no válido");
                labelStatus.Text = "Error al buscar pronóstico";
            }
        }
    }
}
