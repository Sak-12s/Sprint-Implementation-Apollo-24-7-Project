Feature: Verification of enabling notifications
Background:
Given the user clicks on the Notification Preferences
Scenario: Verifictaion of enabling push notifications works successfully

When the user enables the Push Notification
Then the push notification is enabled
Scenario: Verification of enabling SMS notifications works successfully

When the user enables the SMS Notification
Then the sms notification is enabled