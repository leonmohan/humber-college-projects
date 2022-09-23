namespace Lab_3___RentProperty
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.grpInfo = new System.Windows.Forms.GroupBox();
            this.lblFName = new System.Windows.Forms.Label();
            this.txtLName = new System.Windows.Forms.TextBox();
            this.lblLName = new System.Windows.Forms.Label();
            this.txtFName = new System.Windows.Forms.TextBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnBuy = new System.Windows.Forms.Button();
            this.lblRent = new System.Windows.Forms.Label();
            this.grpType = new System.Windows.Forms.GroupBox();
            this.radHouse = new System.Windows.Forms.RadioButton();
            this.radCondo = new System.Windows.Forms.RadioButton();
            this.lblDisplayRent = new System.Windows.Forms.Label();
            this.grpBB = new System.Windows.Forms.GroupBox();
            this.grpNumBeds = new System.Windows.Forms.GroupBox();
            this.rad4Rooms = new System.Windows.Forms.RadioButton();
            this.rad3rooms = new System.Windows.Forms.RadioButton();
            this.rad2rooms = new System.Windows.Forms.RadioButton();
            this.rad1room = new System.Windows.Forms.RadioButton();
            this.grpNumBaths = new System.Windows.Forms.GroupBox();
            this.rad2andhalfbath = new System.Windows.Forms.RadioButton();
            this.rad2bath = new System.Windows.Forms.RadioButton();
            this.rad1AndHalfBath = new System.Windows.Forms.RadioButton();
            this.rad1Bath = new System.Windows.Forms.RadioButton();
            this.lblCondo = new System.Windows.Forms.Label();
            this.lblHouse = new System.Windows.Forms.Label();
            this.cboxCondo = new System.Windows.Forms.ComboBox();
            this.cboxHouse = new System.Windows.Forms.ComboBox();
            this.grpInfo.SuspendLayout();
            this.grpType.SuspendLayout();
            this.grpBB.SuspendLayout();
            this.grpNumBeds.SuspendLayout();
            this.grpNumBaths.SuspendLayout();
            this.SuspendLayout();
            // 
            // grpInfo
            // 
            this.grpInfo.Controls.Add(this.lblFName);
            this.grpInfo.Controls.Add(this.txtLName);
            this.grpInfo.Controls.Add(this.lblLName);
            this.grpInfo.Controls.Add(this.txtFName);
            this.grpInfo.Location = new System.Drawing.Point(12, 57);
            this.grpInfo.Name = "grpInfo";
            this.grpInfo.Size = new System.Drawing.Size(176, 93);
            this.grpInfo.TabIndex = 0;
            this.grpInfo.TabStop = false;
            this.grpInfo.Text = "Buyer\'s Information";
            // 
            // lblFName
            // 
            this.lblFName.AutoSize = true;
            this.lblFName.Location = new System.Drawing.Point(6, 27);
            this.lblFName.Name = "lblFName";
            this.lblFName.Size = new System.Drawing.Size(60, 13);
            this.lblFName.TabIndex = 1;
            this.lblFName.Text = "First Name:";
            // 
            // txtLName
            // 
            this.txtLName.Location = new System.Drawing.Point(68, 60);
            this.txtLName.Margin = new System.Windows.Forms.Padding(4);
            this.txtLName.Name = "txtLName";
            this.txtLName.Size = new System.Drawing.Size(94, 20);
            this.txtLName.TabIndex = 11;
            // 
            // lblLName
            // 
            this.lblLName.AutoSize = true;
            this.lblLName.Location = new System.Drawing.Point(6, 63);
            this.lblLName.Name = "lblLName";
            this.lblLName.Size = new System.Drawing.Size(61, 13);
            this.lblLName.TabIndex = 2;
            this.lblLName.Text = "Last Name:";
            // 
            // txtFName
            // 
            this.txtFName.Location = new System.Drawing.Point(68, 24);
            this.txtFName.Margin = new System.Windows.Forms.Padding(4);
            this.txtFName.Name = "txtFName";
            this.txtFName.Size = new System.Drawing.Size(94, 20);
            this.txtFName.TabIndex = 10;
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(412, 181);
            this.btnExit.Margin = new System.Windows.Forms.Padding(4);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(100, 28);
            this.btnExit.TabIndex = 5;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnClear
            // 
            this.btnClear.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnClear.Location = new System.Drawing.Point(412, 117);
            this.btnClear.Margin = new System.Windows.Forms.Padding(4);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(100, 28);
            this.btnClear.TabIndex = 4;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnBuy
            // 
            this.btnBuy.Location = new System.Drawing.Point(412, 57);
            this.btnBuy.Name = "btnBuy";
            this.btnBuy.Size = new System.Drawing.Size(100, 27);
            this.btnBuy.TabIndex = 3;
            this.btnBuy.Text = "Buy";
            this.btnBuy.UseVisualStyleBackColor = true;
            this.btnBuy.Click += new System.EventHandler(this.btnBuy_Click);
            // 
            // lblRent
            // 
            this.lblRent.AutoSize = true;
            this.lblRent.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblRent.Location = new System.Drawing.Point(22, 26);
            this.lblRent.Name = "lblRent";
            this.lblRent.Size = new System.Drawing.Size(132, 20);
            this.lblRent.TabIndex = 16;
            this.lblRent.Text = "House for Rent";
            // 
            // grpType
            // 
            this.grpType.Controls.Add(this.radHouse);
            this.grpType.Controls.Add(this.radCondo);
            this.grpType.Location = new System.Drawing.Point(252, 57);
            this.grpType.Name = "grpType";
            this.grpType.Size = new System.Drawing.Size(112, 65);
            this.grpType.TabIndex = 1;
            this.grpType.TabStop = false;
            this.grpType.Text = "Type of Property";
            // 
            // radHouse
            // 
            this.radHouse.AutoSize = true;
            this.radHouse.Location = new System.Drawing.Point(6, 44);
            this.radHouse.Name = "radHouse";
            this.radHouse.Size = new System.Drawing.Size(56, 17);
            this.radHouse.TabIndex = 3;
            this.radHouse.Text = "&House";
            this.radHouse.UseVisualStyleBackColor = true;
            this.radHouse.CheckedChanged += new System.EventHandler(this.radHouse_CheckedChanged);
            // 
            // radCondo
            // 
            this.radCondo.AutoSize = true;
            this.radCondo.Location = new System.Drawing.Point(6, 19);
            this.radCondo.Name = "radCondo";
            this.radCondo.Size = new System.Drawing.Size(88, 17);
            this.radCondo.TabIndex = 2;
            this.radCondo.Text = "&Condominium";
            this.radCondo.UseVisualStyleBackColor = true;
            this.radCondo.CheckedChanged += new System.EventHandler(this.radCondo_CheckedChanged);
            // 
            // lblDisplayRent
            // 
            this.lblDisplayRent.Location = new System.Drawing.Point(317, 213);
            this.lblDisplayRent.Name = "lblDisplayRent";
            this.lblDisplayRent.Size = new System.Drawing.Size(183, 148);
            this.lblDisplayRent.TabIndex = 28;
            // 
            // grpBB
            // 
            this.grpBB.Controls.Add(this.grpNumBeds);
            this.grpBB.Controls.Add(this.grpNumBaths);
            this.grpBB.Location = new System.Drawing.Point(26, 204);
            this.grpBB.Name = "grpBB";
            this.grpBB.Size = new System.Drawing.Size(275, 157);
            this.grpBB.TabIndex = 2;
            this.grpBB.TabStop = false;
            this.grpBB.Text = "Beds and Baths";
            // 
            // grpNumBeds
            // 
            this.grpNumBeds.Controls.Add(this.rad4Rooms);
            this.grpNumBeds.Controls.Add(this.rad3rooms);
            this.grpNumBeds.Controls.Add(this.rad2rooms);
            this.grpNumBeds.Controls.Add(this.rad1room);
            this.grpNumBeds.Location = new System.Drawing.Point(9, 27);
            this.grpNumBeds.Name = "grpNumBeds";
            this.grpNumBeds.Size = new System.Drawing.Size(126, 111);
            this.grpNumBeds.TabIndex = 4;
            this.grpNumBeds.TabStop = false;
            this.grpNumBeds.Text = "# of Bedrooms";
            // 
            // rad4Rooms
            // 
            this.rad4Rooms.AutoSize = true;
            this.rad4Rooms.Location = new System.Drawing.Point(6, 88);
            this.rad4Rooms.Name = "rad4Rooms";
            this.rad4Rooms.Size = new System.Drawing.Size(67, 17);
            this.rad4Rooms.TabIndex = 3;
            this.rad4Rooms.Text = "&4 Rooms";
            this.rad4Rooms.UseVisualStyleBackColor = true;
            // 
            // rad3rooms
            // 
            this.rad3rooms.AutoSize = true;
            this.rad3rooms.Location = new System.Drawing.Point(6, 65);
            this.rad3rooms.Name = "rad3rooms";
            this.rad3rooms.Size = new System.Drawing.Size(67, 17);
            this.rad3rooms.TabIndex = 2;
            this.rad3rooms.Text = "&3 Rooms";
            this.rad3rooms.UseVisualStyleBackColor = true;
            // 
            // rad2rooms
            // 
            this.rad2rooms.AutoSize = true;
            this.rad2rooms.Location = new System.Drawing.Point(6, 42);
            this.rad2rooms.Name = "rad2rooms";
            this.rad2rooms.Size = new System.Drawing.Size(67, 17);
            this.rad2rooms.TabIndex = 1;
            this.rad2rooms.Text = "&2 Rooms";
            this.rad2rooms.UseVisualStyleBackColor = true;
            // 
            // rad1room
            // 
            this.rad1room.AutoSize = true;
            this.rad1room.Checked = true;
            this.rad1room.Location = new System.Drawing.Point(6, 19);
            this.rad1room.Name = "rad1room";
            this.rad1room.Size = new System.Drawing.Size(62, 17);
            this.rad1room.TabIndex = 0;
            this.rad1room.TabStop = true;
            this.rad1room.Text = "&1 Room";
            this.rad1room.UseVisualStyleBackColor = true;
            // 
            // grpNumBaths
            // 
            this.grpNumBaths.Controls.Add(this.rad2andhalfbath);
            this.grpNumBaths.Controls.Add(this.rad2bath);
            this.grpNumBaths.Controls.Add(this.rad1AndHalfBath);
            this.grpNumBaths.Controls.Add(this.rad1Bath);
            this.grpNumBaths.Location = new System.Drawing.Point(150, 27);
            this.grpNumBaths.Name = "grpNumBaths";
            this.grpNumBaths.Size = new System.Drawing.Size(108, 111);
            this.grpNumBaths.TabIndex = 3;
            this.grpNumBaths.TabStop = false;
            this.grpNumBaths.Text = "# of Baths";
            // 
            // rad2andhalfbath
            // 
            this.rad2andhalfbath.AutoSize = true;
            this.rad2andhalfbath.Location = new System.Drawing.Point(6, 88);
            this.rad2andhalfbath.Name = "rad2andhalfbath";
            this.rad2andhalfbath.Size = new System.Drawing.Size(40, 17);
            this.rad2andhalfbath.TabIndex = 3;
            this.rad2andhalfbath.Text = "2.&5";
            this.rad2andhalfbath.UseVisualStyleBackColor = true;
            // 
            // rad2bath
            // 
            this.rad2bath.AutoSize = true;
            this.rad2bath.Location = new System.Drawing.Point(6, 65);
            this.rad2bath.Name = "rad2bath";
            this.rad2bath.Size = new System.Drawing.Size(31, 17);
            this.rad2bath.TabIndex = 2;
            this.rad2bath.Text = "&2";
            this.rad2bath.UseVisualStyleBackColor = true;
            // 
            // rad1AndHalfBath
            // 
            this.rad1AndHalfBath.AutoSize = true;
            this.rad1AndHalfBath.Location = new System.Drawing.Point(6, 42);
            this.rad1AndHalfBath.Name = "rad1AndHalfBath";
            this.rad1AndHalfBath.Size = new System.Drawing.Size(40, 17);
            this.rad1AndHalfBath.TabIndex = 1;
            this.rad1AndHalfBath.Text = "&1.5";
            this.rad1AndHalfBath.UseVisualStyleBackColor = true;
            // 
            // rad1Bath
            // 
            this.rad1Bath.AutoSize = true;
            this.rad1Bath.Checked = true;
            this.rad1Bath.Location = new System.Drawing.Point(6, 19);
            this.rad1Bath.Name = "rad1Bath";
            this.rad1Bath.Size = new System.Drawing.Size(34, 17);
            this.rad1Bath.TabIndex = 0;
            this.rad1Bath.TabStop = true;
            this.rad1Bath.Text = "&1 ";
            this.rad1Bath.UseVisualStyleBackColor = true;
            // 
            // lblCondo
            // 
            this.lblCondo.AutoSize = true;
            this.lblCondo.Location = new System.Drawing.Point(204, 137);
            this.lblCondo.Name = "lblCondo";
            this.lblCondo.Size = new System.Drawing.Size(70, 13);
            this.lblCondo.TabIndex = 29;
            this.lblCondo.Text = "Condominium";
            // 
            // lblHouse
            // 
            this.lblHouse.AutoSize = true;
            this.lblHouse.Location = new System.Drawing.Point(308, 137);
            this.lblHouse.Name = "lblHouse";
            this.lblHouse.Size = new System.Drawing.Size(38, 13);
            this.lblHouse.TabIndex = 30;
            this.lblHouse.Text = "House";
            // 
            // cboxCondo
            // 
            this.cboxCondo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboxCondo.FormattingEnabled = true;
            this.cboxCondo.Items.AddRange(new object[] {
            "With amenities",
            "Without amenities"});
            this.cboxCondo.Location = new System.Drawing.Point(196, 165);
            this.cboxCondo.Name = "cboxCondo";
            this.cboxCondo.Size = new System.Drawing.Size(88, 21);
            this.cboxCondo.TabIndex = 31;
            // 
            // cboxHouse
            // 
            this.cboxHouse.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboxHouse.FormattingEnabled = true;
            this.cboxHouse.Items.AddRange(new object[] {
            "Townhouse",
            "Semi-Detached",
            "Detached"});
            this.cboxHouse.Location = new System.Drawing.Point(311, 165);
            this.cboxHouse.Name = "cboxHouse";
            this.cboxHouse.Size = new System.Drawing.Size(90, 21);
            this.cboxHouse.TabIndex = 32;
            this.cboxHouse.SelectedIndexChanged += new System.EventHandler(this.cboxHouse_SelectedIndexChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(525, 386);
            this.Controls.Add(this.cboxHouse);
            this.Controls.Add(this.cboxCondo);
            this.Controls.Add(this.lblHouse);
            this.Controls.Add(this.lblCondo);
            this.Controls.Add(this.lblDisplayRent);
            this.Controls.Add(this.grpBB);
            this.Controls.Add(this.grpType);
            this.Controls.Add(this.grpInfo);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnBuy);
            this.Controls.Add(this.lblRent);
            this.Name = "Form1";
            this.Text = "Leon Mohan";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.grpInfo.ResumeLayout(false);
            this.grpInfo.PerformLayout();
            this.grpType.ResumeLayout(false);
            this.grpType.PerformLayout();
            this.grpBB.ResumeLayout(false);
            this.grpNumBeds.ResumeLayout(false);
            this.grpNumBeds.PerformLayout();
            this.grpNumBaths.ResumeLayout(false);
            this.grpNumBaths.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.GroupBox grpInfo;
        private System.Windows.Forms.Label lblFName;
        private System.Windows.Forms.TextBox txtLName;
        private System.Windows.Forms.Label lblLName;
        private System.Windows.Forms.TextBox txtFName;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnBuy;
        private System.Windows.Forms.Label lblRent;
        private System.Windows.Forms.GroupBox grpType;
        private System.Windows.Forms.RadioButton radHouse;
        private System.Windows.Forms.RadioButton radCondo;
        private System.Windows.Forms.Label lblDisplayRent;
        private System.Windows.Forms.GroupBox grpBB;
        private System.Windows.Forms.GroupBox grpNumBeds;
        private System.Windows.Forms.RadioButton rad4Rooms;
        private System.Windows.Forms.RadioButton rad3rooms;
        private System.Windows.Forms.RadioButton rad2rooms;
        private System.Windows.Forms.RadioButton rad1room;
        private System.Windows.Forms.GroupBox grpNumBaths;
        private System.Windows.Forms.RadioButton rad2andhalfbath;
        private System.Windows.Forms.RadioButton rad2bath;
        private System.Windows.Forms.RadioButton rad1AndHalfBath;
        private System.Windows.Forms.RadioButton rad1Bath;
        private System.Windows.Forms.Label lblCondo;
        private System.Windows.Forms.Label lblHouse;
        private System.Windows.Forms.ComboBox cboxCondo;
        private System.Windows.Forms.ComboBox cboxHouse;
    }
}

