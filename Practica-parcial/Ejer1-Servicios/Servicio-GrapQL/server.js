const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const pronosticoSchema = require('./controllers/PronosticoSchema');
const { sequelize } = require('./config/database');

const app = express();


app.use('/graphql/pronostico', graphqlHTTP({
    schema: pronosticoSchema,
    graphiql: true
}));


sequelize.authenticate()
    .then(() => {
        console.log('Conexión exitosa');

        app.listen(4000, () => {
            console.log('Servidor en http://localhost:4000');
        });
    })
    .catch(err => {
        console.log('Error de conexión', err);
    });
