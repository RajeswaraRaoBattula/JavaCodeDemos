//import logo from './logo.svg';
import './App.css';

import React from "react";
import GroceryList from "./ReactFiles/GroceryList"; 
import Car from "./ReactFiles/Car"; 
import Phone from "./ReactFiles/Phone"; 
import SweetsList from "./ReactFiles/SweetsList";
import Electronics from "./ReactFiles/Electronics";
import CanteenMenu from "./ReactFiles/CanteenMenu";
import JuiceList from "./ReactFiles/JuiceList";
import Restaurant from './ReactFiles/Restaurant';
import TempleList from './ReactFiles/TempleList';

//import 'bootstrap/dist/css/bootstrap.min.css';
import TailorShop from "./ReactFiles/TailorShop";

import Fruits from "./ReactFiles/Fruits";
import TelevisionManager from "./ReactFiles/TelevisionManager";
import MarriageForm from "./ReactFiles/MarriageForm";
import AccessoriesForm from './ReactFiles/AccessoriesForm';
import BakingForm from './ReactFiles/BakingForm';
import FlightBooking from "./ReactFiles/FlightBooking";
import MovieForm from "./ReactFiles/MovieForm";
//import ElectronicProducts from './ReactFiles/ElectronicProducts';
import FurnitureComponents from './ReactFiles/FurnitureComponents';
import FestivalApp from './ReactFiles/FestuvalApp';
import RestaurantForm from './ReactFiles/RestaurantForm';
import ReactCommunication from './ReactFiles/ReactCommunication';
import ChessTournamentForm from './ReactFiles/ChessTournamentForm';
import HockeyForm from './ReactFiles/HockeyForm';
import TailoringInventory from './ReactFiles/AXIOSTailoringInventory';

import { PowerCutProvider } from "./ReactFiles/PowerCutContext";
import SendAnnouncement from "./ReactFiles/SendAnnouncement";
import AnnouncementList from "./ReactFiles/AnnouncementList";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// Import Navbar
import NavbarComponent from "./ReactFiles/NavbarComponent";

// Import Pages
import Home from "./ReactFiles/Home";
import AddTaxpayer from "./ReactFiles/AddTaxpayer";
import TaxpayerList from "./ReactFiles/TaxpayerList";
import CalculateTax from "./ReactFiles/CalculateTax";
import TaxRates from "./ReactFiles/TaxRates";
import Contact from "./ReactFiles/Contact";
import About from "./ReactFiles/About";
import FAQ from "./ReactFiles/FAQ";
import NotFound from "./ReactFiles/NotFound";

function App() {
  const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

  

  return (
    <div>
      <h1 style={{ textAlign: "center" }}>My App</h1>
      
      {/* Grocery List Component */}
      <GroceryList items={groceries} />

      {/* Car Component */}
      <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />

      {/* Phone Component */}
      <Phone />

      {/* SweetList Component */}
      <SweetsList />

      {/* Electronic Component */}
      <Electronics />

      {/* Canteen Component */}
      <CanteenMenu />

      <JuiceList />

      <Restaurant />

      <TempleList />

      <Fruits />

      <TelevisionManager />

      <MarriageForm />

      <AccessoriesForm/>

      <BakingForm />

      <FlightBooking />

      <MovieForm />

      <FurnitureComponents />

      <FestivalApp />

      <RestaurantForm />

      <ReactCommunication />

      <ChessTournamentForm />

      <HockeyForm />

      <TailoringInventory />

      <PowerCutProvider>
      <div className="container mt-4">
        <h2 className="text-center mb-4">⚡ Electricity Power Cut Announcement System ⚡</h2>
        <SendAnnouncement />
        <AnnouncementList />
      </div>
     </PowerCutProvider>

     <Router>
      <NavbarComponent />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-taxpayer" element={<AddTaxpayer />} />
          <Route path="/taxpayer-list" element={<TaxpayerList />} />
          <Route path="/calculate-tax" element={<CalculateTax />} />
          <Route path="/tax-rates" element={<TaxRates />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/faq" element={<FAQ />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
      
    </div>
  );
}

export default App;
