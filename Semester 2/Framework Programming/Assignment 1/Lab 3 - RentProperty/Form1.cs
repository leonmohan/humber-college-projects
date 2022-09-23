using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using PropertyClasses;

namespace Lab_3___RentProperty
{
    public partial class Form1 : Form
    {
        Rent rent;
        
        int numOfBedrooms;
        double numOfBathrooms;
        String propertyType;
        public Form1()
        {
            InitializeComponent();
            AcceptButton = btnBuy;
            CancelButton = btnClear;
        }

        // WHEN BUY BUTTON IS CLICKED
        private void btnBuy_Click(object sender, EventArgs e)
        {
            if (rad1room.Checked)
            {
                numOfBedrooms = 1;
            }
            if (rad2rooms.Checked)
            {
                numOfBedrooms = 2;
            }
            if (rad3rooms.Checked)
            {
                numOfBedrooms = 3;
            }
            if (rad4Rooms.Checked)
            {
                numOfBedrooms = 4;
            }
            if (rad1Bath.Checked) {
                numOfBathrooms = 1;
            }
            if (rad1AndHalfBath.Checked)
            {
                numOfBathrooms = 1.5;
            }
            if (rad2bath.Checked)
            {
                numOfBathrooms = 2;
            }
            if (rad2andhalfbath.Checked)
            {
                numOfBathrooms = 2.5;
            }
            if (cboxHouse.SelectedIndex == 0) {
                propertyType = "townhouse";
            }
            if (cboxHouse.SelectedIndex == 1) {
                propertyType = "semi-detached";
            }
            if (cboxHouse.SelectedIndex == 2)
            {
                propertyType = "detached";
            }
            if (cboxCondo.SelectedIndex == 0)
            {
                propertyType = "condo w/ amenities";
            }
            if (cboxCondo.SelectedIndex == 1)
            {
                propertyType = "condo";
            }

            rent = new Rent(new Buyer(txtFName.Text, txtLName.Text), new Property(numOfBedrooms, numOfBathrooms, propertyType));
            lblDisplayRent.Text = rent.ToString();
            btnClear.Focus();
        }

        // WHEN CLEAR BUTTON IS CLICKED
        private void btnClear_Click(object sender, EventArgs e)
        {
            txtFName.Text = string.Empty;
            txtLName.Text = string.Empty;
            
            foreach (RadioButton rdo in grpNumBeds.Controls.OfType<RadioButton>())
            {
                if (rdo.Checked)
                {
                    rdo.Checked = false;
                    break;
                }
            }

            foreach (RadioButton rdo in grpNumBaths.Controls.OfType<RadioButton>())
            {
                if (rdo.Checked)
                {
                    rdo.Checked = false;
                    break;
                }
            }

            foreach (RadioButton rdo in grpType.Controls.OfType<RadioButton>())
            {
                if (rdo.Checked)
                {
                    rdo.Checked = false;
                    break;
                }
            }


            cboxCondo.Text = string.Empty;
            cboxHouse.Text = string.Empty;
            cboxCondo.Enabled = false;
            cboxHouse.Enabled = false;

            
            rad4Rooms.Enabled = true;
            lblDisplayRent.Text = String.Empty;
            txtFName.Focus();
        }

        // WHEN EXIT BUTTON IS CLICKED
        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        // WHEN FORM LOADS
        private void Form1_Load(object sender, EventArgs e)
        {
            cboxCondo.Enabled = false;
            cboxHouse.Enabled = false;
        }

        // WHEN HOUSE RADIO BUTTON IS SELECTED
        private void radCondo_CheckedChanged(object sender, EventArgs e)
        {
            cboxHouse.Enabled = false;
            cboxHouse.Text = null;
            cboxCondo.Enabled = true;
        }

        // WHEN CONDO RADIO BUTTON IS SELECTED
        private void radHouse_CheckedChanged(object sender, EventArgs e)
        {
            cboxCondo.Enabled = false;
            cboxCondo.Text = null;
            cboxHouse.Enabled = true;
            rad4Rooms.Enabled = true;
        }

        private void cboxHouse_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cboxHouse.SelectedIndex == 0)
            {
                rad4Rooms.Enabled = false;
            }
            else {
                rad4Rooms.Enabled = true;
            }
        }
    }
}
