const { Sequelize } = require('sequelize');

const sequelize = new Sequelize("bd_clima", "root", "", {
    host: "localhost",
    dialect: "mysql",
});

const Pronosticos = sequelize.define("pronosticos", {
    id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },

    fecha: {
        type: Sequelize.DATE,
        allowNull: false
    },
    
    temperatura: {
        type: Sequelize.FLOAT,
        allowNull: false
    }
}, {
    tableName: "pronosticos",
    timestamps: false
});

sequelize.sync();

module.exports = {Pronosticos, sequelize};
