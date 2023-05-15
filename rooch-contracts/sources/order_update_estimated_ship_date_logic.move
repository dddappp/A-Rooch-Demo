module rooch_test_proj1::order_update_estimated_ship_date_logic {
    use std::option;

    use moveos_std::object::Object;
    use moveos_std::storage_context::StorageContext;
    use rooch_test_proj1::day::Day;
    use rooch_test_proj1::order;
    use rooch_test_proj1::order_estimated_ship_date_updated;

    friend rooch_test_proj1::order_aggregate;

    public(friend) fun verify(
        _storage_ctx: &mut StorageContext,
        _account: &signer,
        estimated_ship_date: Day,
        order_obj: &Object<order::Order>,
    ): order::OrderEstimatedShipDateUpdated {
        order::new_order_estimated_ship_date_updated(
            order_obj,
            estimated_ship_date,
        )
    }

    public(friend) fun mutate(
        _storage_ctx: &mut StorageContext,
        order_estimated_ship_date_updated: &order::OrderEstimatedShipDateUpdated,
        order_obj: Object<order::Order>,
    ): Object<order::Order> {
        order::set_estimated_ship_date(
            &mut order_obj,
            option::some(order_estimated_ship_date_updated::estimated_ship_date(order_estimated_ship_date_updated)),
        );
        order_obj
    }
}
