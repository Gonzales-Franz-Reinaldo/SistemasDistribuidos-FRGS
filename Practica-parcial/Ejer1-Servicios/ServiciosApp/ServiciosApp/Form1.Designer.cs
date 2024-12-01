namespace ServiciosApp
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.comboTipoService = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.comboTipoOperacion = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.textFecha = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textTemperatura = new System.Windows.Forms.TextBox();
            this.btnEjecutar = new System.Windows.Forms.Button();
            this.listResultado = new System.Windows.Forms.ListBox();
            this.labelStatus = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // comboTipoService
            // 
            this.comboTipoService.FormattingEnabled = true;
            this.comboTipoService.Items.AddRange(new object[] {
            "Rest",
            "GraphQL"});
            this.comboTipoService.Location = new System.Drawing.Point(331, 41);
            this.comboTipoService.Name = "comboTipoService";
            this.comboTipoService.Size = new System.Drawing.Size(227, 24);
            this.comboTipoService.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(195, 41);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 16);
            this.label1.TabIndex = 1;
            this.label1.Text = "Tipo Servicio";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(195, 91);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(101, 16);
            this.label2.TabIndex = 1;
            this.label2.Text = "Tipo Operación";
            // 
            // comboTipoOperacion
            // 
            this.comboTipoOperacion.FormattingEnabled = true;
            this.comboTipoOperacion.Items.AddRange(new object[] {
            "Listar",
            "Actualizar",
            "Insertar",
            "Buscar",
            "Eliminar"});
            this.comboTipoOperacion.Location = new System.Drawing.Point(331, 83);
            this.comboTipoOperacion.Name = "comboTipoOperacion";
            this.comboTipoOperacion.Size = new System.Drawing.Size(227, 24);
            this.comboTipoOperacion.TabIndex = 0;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(215, 143);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(48, 16);
            this.label3.TabIndex = 2;
            this.label3.Text = "Fecha:";
            // 
            // textFecha
            // 
            this.textFecha.Location = new System.Drawing.Point(331, 137);
            this.textFecha.Name = "textFecha";
            this.textFecha.Size = new System.Drawing.Size(165, 22);
            this.textFecha.TabIndex = 3;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(215, 176);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(88, 16);
            this.label4.TabIndex = 2;
            this.label4.Text = "Temperatura:";
            // 
            // textTemperatura
            // 
            this.textTemperatura.Location = new System.Drawing.Point(331, 173);
            this.textTemperatura.Name = "textTemperatura";
            this.textTemperatura.Size = new System.Drawing.Size(165, 22);
            this.textTemperatura.TabIndex = 3;
            // 
            // btnEjecutar
            // 
            this.btnEjecutar.Location = new System.Drawing.Point(350, 212);
            this.btnEjecutar.Name = "btnEjecutar";
            this.btnEjecutar.Size = new System.Drawing.Size(146, 51);
            this.btnEjecutar.TabIndex = 4;
            this.btnEjecutar.Text = "Ejecutar Operacion";
            this.btnEjecutar.UseVisualStyleBackColor = true;
            this.btnEjecutar.Click += new System.EventHandler(this.btnEjecutar_Click);
            // 
            // listResultado
            // 
            this.listResultado.FormattingEnabled = true;
            this.listResultado.ItemHeight = 16;
            this.listResultado.Location = new System.Drawing.Point(181, 286);
            this.listResultado.Name = "listResultado";
            this.listResultado.Size = new System.Drawing.Size(489, 148);
            this.listResultado.TabIndex = 5;
            // 
            // labelStatus
            // 
            this.labelStatus.AutoSize = true;
            this.labelStatus.Location = new System.Drawing.Point(370, 437);
            this.labelStatus.Name = "labelStatus";
            this.labelStatus.Size = new System.Drawing.Size(70, 16);
            this.labelStatus.TabIndex = 2;
            this.labelStatus.Text = "Response";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(790, 473);
            this.Controls.Add(this.listResultado);
            this.Controls.Add(this.btnEjecutar);
            this.Controls.Add(this.textTemperatura);
            this.Controls.Add(this.textFecha);
            this.Controls.Add(this.labelStatus);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboTipoOperacion);
            this.Controls.Add(this.comboTipoService);
            this.Name = "Form1";
            this.Text = "Servicios";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboTipoService;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox comboTipoOperacion;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textFecha;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textTemperatura;
        private System.Windows.Forms.Button btnEjecutar;
        private System.Windows.Forms.ListBox listResultado;
        private System.Windows.Forms.Label labelStatus;
    }
}

