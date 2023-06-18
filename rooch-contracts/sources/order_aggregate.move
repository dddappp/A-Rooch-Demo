// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::order_aggregate {
    use moveos_std::object_id::ObjectID;
    use moveos_std::storage_context::StorageContext;
    use rooch_test_proj1::day::{Self, Day};
    use rooch_test_proj1::month;
    use rooch_test_proj1::order;
    use rooch_test_proj1::order_add_order_ship_group_logic;
    use rooch_test_proj1::order_cancel_order_ship_group_quantity_logic;
    use rooch_test_proj1::order_create_logic;
    use rooch_test_proj1::order_remove_item_logic;
    use rooch_test_proj1::order_remove_order_ship_group_item_logic;
    use rooch_test_proj1::order_update_estimated_ship_date_logic;
    use rooch_test_proj1::order_update_item_quantity_logic;
    use rooch_test_proj1::year;
    use std::string::String;

    public entry fun create(
        storage_ctx: &mut StorageContext,
        account: &signer,
        order_id: String,
        product_obj_id: ObjectID,
        quantity: u64,
    ) {
        let order_created = order_create_logic::verify(
            storage_ctx,
            account,
            order_id,
            product_obj_id,
            quantity,
        );
        let order_obj = order_create_logic::mutate(
            storage_ctx,
            &order_created,
        );
        order::set_order_created_id(&mut order_created, order::id(&order_obj));
        order::add_order(storage_ctx, order_obj);
        order::emit_order_created(storage_ctx, order_created);
    }


    public entry fun remove_item(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        product_obj_id: ObjectID,
    ) {
        let order_obj = order::remove_order(storage_ctx, id);
        let order_item_removed = order_remove_item_logic::verify(
            storage_ctx,
            account,
            product_obj_id,
            &order_obj,
        );
        let updated_order_obj = order_remove_item_logic::mutate(
            storage_ctx,
            &order_item_removed,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_item_removed(storage_ctx, order_item_removed);
    }


    public entry fun update_item_quantity(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        product_obj_id: ObjectID,
        quantity: u64,
    ) {
        let order_obj = order::remove_order(storage_ctx, id);
        let order_item_quantity_updated = order_update_item_quantity_logic::verify(
            storage_ctx,
            account,
            product_obj_id,
            quantity,
            &order_obj,
        );
        let updated_order_obj = order_update_item_quantity_logic::mutate(
            storage_ctx,
            &order_item_quantity_updated,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_item_quantity_updated(storage_ctx, order_item_quantity_updated);
    }


    public entry fun update_estimated_ship_date(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        estimated_ship_date_month_year_number: u16,
        estimated_ship_date_month_year_calendar: String,
        estimated_ship_date_month_number: u8,
        estimated_ship_date_month_is_leap: bool,
        estimated_ship_date_number: u8,
        estimated_ship_date_time_zone: String,
    ) {
        let estimated_ship_date: Day = day::new(
            month::new(
                year::new(
                    estimated_ship_date_month_year_number,
                    estimated_ship_date_month_year_calendar,
                ),
                estimated_ship_date_month_number,
                estimated_ship_date_month_is_leap,
            ),
            estimated_ship_date_number,
            estimated_ship_date_time_zone,
        );
        let order_obj = order::remove_order(storage_ctx, id);
        let order_estimated_ship_date_updated = order_update_estimated_ship_date_logic::verify(
            storage_ctx,
            account,
            estimated_ship_date,
            &order_obj,
        );
        let updated_order_obj = order_update_estimated_ship_date_logic::mutate(
            storage_ctx,
            &order_estimated_ship_date_updated,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_estimated_ship_date_updated(storage_ctx, order_estimated_ship_date_updated);
    }


    public entry fun add_order_ship_group(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        ship_group_seq_id: u8,
        shipment_method: String,
        product_obj_id: ObjectID,
        quantity: u64,
    ) {
        let order_obj = order::remove_order(storage_ctx, id);
        let order_ship_group_added = order_add_order_ship_group_logic::verify(
            storage_ctx,
            account,
            ship_group_seq_id,
            shipment_method,
            product_obj_id,
            quantity,
            &order_obj,
        );
        let updated_order_obj = order_add_order_ship_group_logic::mutate(
            storage_ctx,
            &order_ship_group_added,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_ship_group_added(storage_ctx, order_ship_group_added);
    }


    public entry fun cancel_order_ship_group_quantity(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        ship_group_seq_id: u8,
        product_obj_id: ObjectID,
        cancel_quantity: u64,
    ) {
        let order_obj = order::remove_order(storage_ctx, id);
        let order_ship_group_quantity_canceled = order_cancel_order_ship_group_quantity_logic::verify(
            storage_ctx,
            account,
            ship_group_seq_id,
            product_obj_id,
            cancel_quantity,
            &order_obj,
        );
        let updated_order_obj = order_cancel_order_ship_group_quantity_logic::mutate(
            storage_ctx,
            &order_ship_group_quantity_canceled,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_ship_group_quantity_canceled(storage_ctx, order_ship_group_quantity_canceled);
    }


    public entry fun remove_order_ship_group_item(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        ship_group_seq_id: u8,
        product_obj_id: ObjectID,
    ) {
        let order_obj = order::remove_order(storage_ctx, id);
        let order_ship_group_item_removed = order_remove_order_ship_group_item_logic::verify(
            storage_ctx,
            account,
            ship_group_seq_id,
            product_obj_id,
            &order_obj,
        );
        let updated_order_obj = order_remove_order_ship_group_item_logic::mutate(
            storage_ctx,
            &order_ship_group_item_removed,
            order_obj,
        );
        order::update_version_and_add(storage_ctx, updated_order_obj);
        order::emit_order_ship_group_item_removed(storage_ctx, order_ship_group_item_removed);
    }

}
