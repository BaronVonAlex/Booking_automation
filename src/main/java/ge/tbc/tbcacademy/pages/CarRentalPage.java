package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CarRentalPage {
    public SelenideElement
            pickUpLocationDiv = $x("//div[@data-testid='sbc-fl-text-input__container']"),
            pickUpDateButton = $("#searchbox-toolbox-date-picker-pickup-date"),
            pickUpDateSelect = $("[data-testid='searchbox-toolbox-pickup-time']"),
            dropOffDate = $("#searchbox-toolbox-date-picker-dropoff-date"),
            dropOffTime = $("[data-testid='searchbox-toolbox-dropoff-time']"),
            searchButton = $x("//button[@data-testid='searchbox-toolbox-submit-button']"),
            supplierList = $("[data-testid='supplier-list']"),
            faqsList = $("[data-testid='faqs-list']"),
            footer = $("#booking-footer"),
            footerTopMenu = $("#footer_top_menu"),
            pickupLocationTxt = $x("//label[@for='Pick-up location']"),
            carRentalHeader = $x("//h1[text()='Car rentals for any kind of trip']");
}
