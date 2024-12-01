
const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLList, GraphQLNonNull, GraphQLInt, GraphQLFloat } = require('graphql');
const { Sequelize } = require("sequelize");
const { Pronosticos } = require('../config/database');

const PronosticoType = new GraphQLObjectType({
    name: 'Pronostico',
    fields: {
        id: { type: GraphQLInt },
        fecha: { type: GraphQLString },
        temperatura: { type: GraphQLFloat },
    }
});

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        allPronosticos: {
            type: new GraphQLList(PronosticoType),

            resolve(parent, args) {
                return Pronosticos.findAll();
            }
        },

        pronostico: {
            type: PronosticoType,
            args: {
                fecha: { type: GraphQLString }
            },

            resolve(parent, args) {
                return Pronosticos.findOne({ where: { fecha: Sequelize.literal(`DATE('${args.fecha}')`) } });
            }
        }
    }
});


const Mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        createPronostico: {
            type: PronosticoType,
            args: {
                fecha: { type: new GraphQLNonNull(GraphQLString) },
                temperatura: { type: new GraphQLNonNull(GraphQLFloat) }
            },

            resolve(parent, args) {
                return Pronosticos.create(args);
            }
        },

        updatePronostico: {
            type: PronosticoType,
            args: {
                fecha: { type: new GraphQLNonNull(GraphQLString) },
                temperatura: { type: GraphQLFloat }
            },

            // resolve(parent, args) {
            //     return Pronosticos.findOne({ where: { fecha: args.fecha } }) // Usa el campo fecha directamente
            //         .then(pronostico => {
            //             if (!pronostico) throw new Error(`No se encontró un pronóstico para la fecha ${args.fecha}`);

            //             return pronostico.update({ args });
            //         });
            // }

            resolve(parent, args) {
                return Pronosticos.findOne({
                    where: Sequelize.where(
                        Sequelize.fn('DATE', Sequelize.col('fecha')), // Extrae solo la parte de la fecha
                        args.fecha
                    )
                }).then(pronostico => {
                    if (!pronostico) throw new Error(`No se encontró un pronóstico para la fecha ${args.fecha}`);

                    return pronostico.update({ temperatura: args.temperatura });
                });
            }


        },

        deletePronostico: {
            type: PronosticoType,
            args: {
                id: { type: GraphQLInt }, // Campo opcional
                fecha: { type: new GraphQLNonNull(GraphQLString) }
            },

            resolve(parent, args) {
                return Pronosticos.findOne({
                    where: Sequelize.where(
                        Sequelize.fn('DATE', Sequelize.col('fecha')), // Extrae solo la parte de la fecha
                        args.fecha
                    )
                })
                    .then(pronostico => {
                        if (!pronostico) throw new Error(`No se encontró un pronóstico para la fecha ${args.fecha}`);

                        return pronostico.destroy();
                    });
            }
        }
    }
});


module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation: Mutation
});