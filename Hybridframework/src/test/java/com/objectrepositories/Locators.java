package com.objectrepositories;

import org.openqa.selenium.By;

public class Locators {
	//public final ByPagename_webelementname_type=By.locator name("locator value");
	public final By Fb_login_Email_editbox = By.name("email");
	public final By Fb_login_password_editbox = By.name("pass");
	public final By Fb_login_login_button=By.tagName("button");
	//Jri creataccount
	public final By jri_login_creataccount_hyperlink = By.linkText("Create New Account");
	public final By jri_login_name_editbox = By.name("signup_name");
	public final By jri_login_mobilenum_editbox = By.name("signup_mobileno");
	public final By jri_login_Email_editbox = By.name("signup_email");
	public final By jri_login_password_editbox = By.name("signup_password");
	public final By jri_login_checkbox_editbox = By.name("checkbox");
	public final By jri_login_creteaccount_button = By.id("imgbtnSubmit");
	//Jri signin
	public final By jri_login_signin_hyperlink = By.linkText("Sign in");
	public final By jri_login_signin_Email_editbox = By.name("txtUserName");
	public final By jri_login_signin_password_editbox = By.name("txtPasswd");
	public final By jri_login_signin_captchacode_editbox = By.name("txtCaptcha");
	public final By jri_login_signin_signin_button = By.name("imgbtnSignin");
	//windowhandling
	public final By greenmountain_contactus_linktext = By.linkText("Contact Us");
	public final By greenmountain_cancel_botton = By.id("cancel");
	//Popuphandling
	public final By justrechargeitsignin_facebooksignin_button=By.xpath("//*[@id=\"signinpanel\"]/tbody/tr/td[3]/table/tbody/tr[2]/td/a/img");
	//Assignment18
	public final By demoqa_newtab_button=By.id("tabButton");
	public final By demoqa_newwindow_button=By.xpath("//*[@id='windowButton']");
	//TTD Website
	public final By TTDWebsite_country_dropdown=By.name("countryS");
}
